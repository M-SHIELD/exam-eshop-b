<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单ID" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="订单ID"></el-input>
    </el-form-item>
    <el-form-item label="用户ID" prop="uid">
      <el-input v-model="dataForm.uid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="评分" prop="score">
      <el-input v-model="dataForm.score" placeholder="评分"></el-input>
    </el-form-item>
    <el-form-item label="评价内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="评价内容"></el-input>
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
          orderId: '',
          uid: '',
          score: '',
          content: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '订单ID不能为空', trigger: 'blur' }
          ],
          uid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          score: [
            { required: true, message: '评分不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '评价内容不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/evaluation/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.evaluation.orderId
                this.dataForm.uid = data.evaluation.uid
                this.dataForm.score = data.evaluation.score
                this.dataForm.content = data.evaluation.content
                this.dataForm.createTime = data.evaluation.createTime
                this.dataForm.updateTime = data.evaluation.updateTime
                this.dataForm.isDel = data.evaluation.isDel
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
              url: this.$http.adornUrl(`/eshop/evaluation/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'uid': this.dataForm.uid,
                'score': this.dataForm.score,
                'content': this.dataForm.content,
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
