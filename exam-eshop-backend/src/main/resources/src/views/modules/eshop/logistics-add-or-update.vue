<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单ID" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="订单ID"></el-input>
    </el-form-item>
    <el-form-item label="物流单号" prop="logisticsNo">
      <el-input v-model="dataForm.logisticsNo" placeholder="物流单号"></el-input>
    </el-form-item>
    <el-form-item label="物流公司名称" prop="logisticsCompany">
      <el-input v-model="dataForm.logisticsCompany" placeholder="物流公司名称"></el-input>
    </el-form-item>
    <el-form-item label="物流状态，0-待发货，1-已发货，2-已签收" prop="status">
      <el-input v-model="dataForm.status" placeholder="物流状态，0-待发货，1-已发货，2-已签收"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="是否删除，0-否，1-是" prop="isDel">
      <el-input v-model="dataForm.isDel" placeholder="是否删除，0-否，1-是"></el-input>
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
          logisticsNo: '',
          logisticsCompany: '',
          status: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '订单ID不能为空', trigger: 'blur' }
          ],
          logisticsNo: [
            { required: true, message: '物流单号不能为空', trigger: 'blur' }
          ],
          logisticsCompany: [
            { required: true, message: '物流公司名称不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '物流状态，0-待发货，1-已发货，2-已签收不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          isDel: [
            { required: true, message: '是否删除，0-否，1-是不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/logistics/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.logistics.orderId
                this.dataForm.logisticsNo = data.logistics.logisticsNo
                this.dataForm.logisticsCompany = data.logistics.logisticsCompany
                this.dataForm.status = data.logistics.status
                this.dataForm.createTime = data.logistics.createTime
                this.dataForm.updateTime = data.logistics.updateTime
                this.dataForm.isDel = data.logistics.isDel
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
              url: this.$http.adornUrl(`/eshop/logistics/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'logisticsNo': this.dataForm.logisticsNo,
                'logisticsCompany': this.dataForm.logisticsCompany,
                'status': this.dataForm.status,
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
