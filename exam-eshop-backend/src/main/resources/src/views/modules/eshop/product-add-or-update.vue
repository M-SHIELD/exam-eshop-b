<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="商品名称"></el-input>
    </el-form-item>
    <el-form-item label="商品描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="商品描述"></el-input>
    </el-form-item>
    <el-form-item label="商品分类ID" prop="categoryId">
      <el-input v-model="dataForm.categoryId" placeholder="商品分类ID"></el-input>
    </el-form-item>
    <el-form-item label="商品价格" prop="price">
      <el-input v-model="dataForm.price" placeholder="商品价格"></el-input>
    </el-form-item>
    <el-form-item label="商品库存" prop="stock">
      <el-input v-model="dataForm.stock" placeholder="商品库存"></el-input>
    </el-form-item>
    <el-form-item label="商品销量" prop="sales">
      <el-input v-model="dataForm.sales" placeholder="商品销量"></el-input>
    </el-form-item>
    <el-form-item label="是否为积分商品，0表示不是，1表示是" prop="isIntegral">
      <el-input v-model="dataForm.isIntegral" placeholder="是否为积分商品，0表示不是，1表示是"></el-input>
    </el-form-item>
    <el-form-item label="商品状态，0：下架，1：在售" prop="status">
      <el-input v-model="dataForm.status" placeholder="商品状态，0：下架，1：在售"></el-input>
    </el-form-item>
    <el-form-item label="商品创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="商品创建时间"></el-input>
    </el-form-item>
    <el-form-item label="商品更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="商品更新时间"></el-input>
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
          name: '',
          description: '',
          categoryId: '',
          price: '',
          stock: '',
          sales: '',
          isIntegral: '',
          status: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          name: [
            { required: true, message: '商品名称不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '商品描述不能为空', trigger: 'blur' }
          ],
          categoryId: [
            { required: true, message: '商品分类ID不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '商品价格不能为空', trigger: 'blur' }
          ],
          stock: [
            { required: true, message: '商品库存不能为空', trigger: 'blur' }
          ],
          sales: [
            { required: true, message: '商品销量不能为空', trigger: 'blur' }
          ],
          isIntegral: [
            { required: true, message: '是否为积分商品，0表示不是，1表示是不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '商品状态，0：下架，1：在售不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '商品创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '商品更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/product/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.product.name
                this.dataForm.description = data.product.description
                this.dataForm.categoryId = data.product.categoryId
                this.dataForm.price = data.product.price
                this.dataForm.stock = data.product.stock
                this.dataForm.sales = data.product.sales
                this.dataForm.isIntegral = data.product.isIntegral
                this.dataForm.status = data.product.status
                this.dataForm.createTime = data.product.createTime
                this.dataForm.updateTime = data.product.updateTime
                this.dataForm.isDel = data.product.isDel
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
              url: this.$http.adornUrl(`/eshop/product/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'description': this.dataForm.description,
                'categoryId': this.dataForm.categoryId,
                'price': this.dataForm.price,
                'stock': this.dataForm.stock,
                'sales': this.dataForm.sales,
                'isIntegral': this.dataForm.isIntegral,
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
