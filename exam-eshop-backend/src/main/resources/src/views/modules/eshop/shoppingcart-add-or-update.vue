<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户ID" prop="uid">
      <el-input v-model="dataForm.uid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="商品ID" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品ID"></el-input>
    </el-form-item>
    <el-form-item label="SKU ID" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder="SKU ID"></el-input>
    </el-form-item>
    <el-form-item label="商品数量" prop="quantity">
      <el-input v-model="dataForm.quantity" placeholder="商品数量"></el-input>
    </el-form-item>
    <el-form-item label="是否选中，1为选中，0为未选中" prop="selected">
      <el-input v-model="dataForm.selected" placeholder="是否选中，1为选中，0为未选中"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="是否删除，0为未删除，1为已删除" prop="isDel">
      <el-input v-model="dataForm.isDel" placeholder="是否删除，0为未删除，1为已删除"></el-input>
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
          productId: '',
          skuId: '',
          quantity: '',
          selected: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          uid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品ID不能为空', trigger: 'blur' }
          ],
          skuId: [
            { required: true, message: 'SKU ID不能为空', trigger: 'blur' }
          ],
          quantity: [
            { required: true, message: '商品数量不能为空', trigger: 'blur' }
          ],
          selected: [
            { required: true, message: '是否选中，1为选中，0为未选中不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          isDel: [
            { required: true, message: '是否删除，0为未删除，1为已删除不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/shoppingcart/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uid = data.shoppingCart.uid
                this.dataForm.productId = data.shoppingCart.productId
                this.dataForm.skuId = data.shoppingCart.skuId
                this.dataForm.quantity = data.shoppingCart.quantity
                this.dataForm.selected = data.shoppingCart.selected
                this.dataForm.createTime = data.shoppingCart.createTime
                this.dataForm.updateTime = data.shoppingCart.updateTime
                this.dataForm.isDel = data.shoppingCart.isDel
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
              url: this.$http.adornUrl(`/eshop/shoppingcart/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uid': this.dataForm.uid,
                'productId': this.dataForm.productId,
                'skuId': this.dataForm.skuId,
                'quantity': this.dataForm.quantity,
                'selected': this.dataForm.selected,
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
