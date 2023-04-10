<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户ID" prop="uid">
      <el-input v-model="dataForm.uid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="积分总数" prop="totalPoint">
      <el-input v-model="dataForm.totalPoint" placeholder="积分总数"></el-input>
    </el-form-item>
    <el-form-item label="可用积分" prop="availablePoint">
      <el-input v-model="dataForm.availablePoint" placeholder="可用积分"></el-input>
    </el-form-item>
    <el-form-item label="冻结积分" prop="frozenPoint">
      <el-input v-model="dataForm.frozenPoint" placeholder="冻结积分"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="是否删除，0表示未删除，1表示已删除" prop="isDel">
      <el-input v-model="dataForm.isDel" placeholder="是否删除，0表示未删除，1表示已删除"></el-input>
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
          uid: '',
          totalPoint: '',
          availablePoint: '',
          frozenPoint: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          uid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          totalPoint: [
            { required: true, message: '积分总数不能为空', trigger: 'blur' }
          ],
          availablePoint: [
            { required: true, message: '可用积分不能为空', trigger: 'blur' }
          ],
          frozenPoint: [
            { required: true, message: '冻结积分不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          isDel: [
            { required: true, message: '是否删除，0表示未删除，1表示已删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/point/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uid = data.point.uid
                this.dataForm.totalPoint = data.point.totalPoint
                this.dataForm.availablePoint = data.point.availablePoint
                this.dataForm.frozenPoint = data.point.frozenPoint
                this.dataForm.createTime = data.point.createTime
                this.dataForm.updateTime = data.point.updateTime
                this.dataForm.isDel = data.point.isDel
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
              url: this.$http.adornUrl(`/eshop/point/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uid': this.dataForm.uid,
                'totalPoint': this.dataForm.totalPoint,
                'availablePoint': this.dataForm.availablePoint,
                'frozenPoint': this.dataForm.frozenPoint,
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
