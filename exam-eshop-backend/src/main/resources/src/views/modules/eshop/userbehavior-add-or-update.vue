<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户ID" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="商品ID" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品ID"></el-input>
    </el-form-item>
    <el-form-item label="用户行为类型，1：收藏，2：点赞，3：足迹" prop="behaviorType">
      <el-input v-model="dataForm.behaviorType" placeholder="用户行为类型，1：收藏，2：点赞，3：足迹"></el-input>
    </el-form-item>
    <el-form-item label="行为创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="行为创建时间"></el-input>
    </el-form-item>
    <el-form-item label="行为更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="行为更新时间"></el-input>
    </el-form-item>
    <el-form-item label="是否删除，0：否，1：是" prop="isDel">
      <el-input v-model="dataForm.isDel" placeholder="是否删除，0：否，1：是"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userId: '',
          productId: '',
          behaviorType: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品ID不能为空', trigger: 'blur' }
          ],
          behaviorType: [
            { required: true, message: '用户行为类型，1：收藏，2：点赞，3：足迹不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '行为创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '行为更新时间不能为空', trigger: 'blur' }
          ],
          isDel: [
            { required: true, message: '是否删除，0：否，1：是不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/eshop/userbehavior/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.userBehavior.userId
                this.dataForm.productId = data.userBehavior.productId
                this.dataForm.behaviorType = data.userBehavior.behaviorType
                this.dataForm.createTime = data.userBehavior.createTime
                this.dataForm.updateTime = data.userBehavior.updateTime
                this.dataForm.isDel = data.userBehavior.isDel
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/eshop/userbehavior/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'productId': this.dataForm.productId,
                'behaviorType': this.dataForm.behaviorType,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'isDel': this.dataForm.isDel
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
