<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单号" prop="orderNo">
      <el-input v-model="dataForm.orderNo" placeholder="订单号"></el-input>
    </el-form-item>
    <el-form-item label="用户ID" prop="uid">
      <el-input v-model="dataForm.uid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="订单总金额" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder="订单总金额"></el-input>
    </el-form-item>
    <el-form-item label="实际支付金额" prop="payAmount">
      <el-input v-model="dataForm.payAmount" placeholder="实际支付金额"></el-input>
    </el-form-item>
    <el-form-item label="支付方式，1：支付宝，2：微信" prop="payType">
      <el-input v-model="dataForm.payType" placeholder="支付方式，1：支付宝，2：微信"></el-input>
    </el-form-item>
    <el-form-item label="订单状态，0：待支付，1：已支付，2：已发货，3：已收货，4：已完成，5：已取消，6：已退款，7：已删除" prop="status">
      <el-input v-model="dataForm.status" placeholder="订单状态，0：待支付，1：已支付，2：已发货，3：已收货，4：已完成，5：已取消，6：已退款，7：已删除"></el-input>
    </el-form-item>
    <el-form-item label="订单创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="订单创建时间"></el-input>
    </el-form-item>
    <el-form-item label="订单更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="订单更新时间"></el-input>
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
          orderNo: '',
          uid: '',
          totalAmount: '',
          payAmount: '',
          payType: '',
          status: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          orderNo: [
            { required: true, message: '订单号不能为空', trigger: 'blur' }
          ],
          uid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '订单总金额不能为空', trigger: 'blur' }
          ],
          payAmount: [
            { required: true, message: '实际支付金额不能为空', trigger: 'blur' }
          ],
          payType: [
            { required: true, message: '支付方式，1：支付宝，2：微信不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '订单状态，0：待支付，1：已支付，2：已发货，3：已收货，4：已完成，5：已取消，6：已退款，7：已删除不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '订单创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '订单更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/order/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderNo = data.order.orderNo
                this.dataForm.uid = data.order.uid
                this.dataForm.totalAmount = data.order.totalAmount
                this.dataForm.payAmount = data.order.payAmount
                this.dataForm.payType = data.order.payType
                this.dataForm.status = data.order.status
                this.dataForm.createTime = data.order.createTime
                this.dataForm.updateTime = data.order.updateTime
                this.dataForm.isDel = data.order.isDel
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
              url: this.$http.adornUrl(`/eshop/order/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderNo': this.dataForm.orderNo,
                'uid': this.dataForm.uid,
                'totalAmount': this.dataForm.totalAmount,
                'payAmount': this.dataForm.payAmount,
                'payType': this.dataForm.payType,
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
