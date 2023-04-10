<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品ID" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品ID"></el-input>
    </el-form-item>
    <el-form-item label="SKU编码" prop="skuCode">
      <el-input v-model="dataForm.skuCode" placeholder="SKU编码"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="库存" prop="stock">
      <el-input v-model="dataForm.stock" placeholder="库存"></el-input>
    </el-form-item>
    <el-form-item label="规格，如"颜色:红色,尺寸:XL"" prop="specification">
      <el-input v-model="dataForm.specification" placeholder="规格，如"颜色:红色,尺寸:XL""></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          productId: '',
          skuCode: '',
          price: '',
          stock: '',
          specification: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          productId: [
            { required: true, message: '商品ID不能为空', trigger: 'blur' }
          ],
          skuCode: [
            { required: true, message: 'SKU编码不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          stock: [
            { required: true, message: '库存不能为空', trigger: 'blur' }
          ],
          specification: [
            { required: true, message: '规格，如"颜色:红色,尺寸:XL"不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/sku/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productId = data.sku.productId
                this.dataForm.skuCode = data.sku.skuCode
                this.dataForm.price = data.sku.price
                this.dataForm.stock = data.sku.stock
                this.dataForm.specification = data.sku.specification
                this.dataForm.createTime = data.sku.createTime
                this.dataForm.updateTime = data.sku.updateTime
                this.dataForm.isDel = data.sku.isDel
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
              url: this.$http.adornUrl(`/eshop/sku/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productId': this.dataForm.productId,
                'skuCode': this.dataForm.skuCode,
                'price': this.dataForm.price,
                'stock': this.dataForm.stock,
                'specification': this.dataForm.specification,
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
