<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="订单ID" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="订单ID"></el-input>
    </el-form-item>
    <el-form-item label="商品ID" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品ID"></el-input>
    </el-form-item>
    <el-form-item label="商品名称" prop="productName">
      <el-input v-model="dataForm.productName" placeholder="商品名称"></el-input>
    </el-form-item>
    <el-form-item label="商品图片" prop="productImage">
      <el-input v-model="dataForm.productImage" placeholder="商品图片"></el-input>
    </el-form-item>
    <el-form-item label="商品单价" prop="productPrice">
      <el-input v-model="dataForm.productPrice" placeholder="商品单价"></el-input>
    </el-form-item>
    <el-form-item label="商品数量" prop="quantity">
      <el-input v-model="dataForm.quantity" placeholder="商品数量"></el-input>
    </el-form-item>
    <el-form-item label="小计金额" prop="subtotalAmount">
      <el-input v-model="dataForm.subtotalAmount" placeholder="小计金额"></el-input>
    </el-form-item>
    <el-form-item label="订单详情创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="订单详情创建时间"></el-input>
    </el-form-item>
    <el-form-item label="订单详情更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="订单详情更新时间"></el-input>
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
          orderId: '',
          productId: '',
          productName: '',
          productImage: '',
          productPrice: '',
          quantity: '',
          subtotalAmount: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '订单ID不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品ID不能为空', trigger: 'blur' }
          ],
          productName: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          productImage: [
            { required: true, message: '商品图片不能为空', trigger: 'blur' }
          ],
          productPrice: [
            { required: true, message: '商品单价不能为空', trigger: 'blur' }
          ],
          quantity: [
            { required: true, message: '商品数量不能为空', trigger: 'blur' }
          ],
          subtotalAmount: [
            { required: true, message: '小计金额不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '订单详情创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '订单详情更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/orderitem/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.orderItem.orderId
                this.dataForm.productId = data.orderItem.productId
                this.dataForm.productName = data.orderItem.productName
                this.dataForm.productImage = data.orderItem.productImage
                this.dataForm.productPrice = data.orderItem.productPrice
                this.dataForm.quantity = data.orderItem.quantity
                this.dataForm.subtotalAmount = data.orderItem.subtotalAmount
                this.dataForm.createTime = data.orderItem.createTime
                this.dataForm.updateTime = data.orderItem.updateTime
                this.dataForm.isDel = data.orderItem.isDel
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
              url: this.$http.adornUrl(`/eshop/orderitem/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'productId': this.dataForm.productId,
                'productName': this.dataForm.productName,
                'productImage': this.dataForm.productImage,
                'productPrice': this.dataForm.productPrice,
                'quantity': this.dataForm.quantity,
                'subtotalAmount': this.dataForm.subtotalAmount,
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
