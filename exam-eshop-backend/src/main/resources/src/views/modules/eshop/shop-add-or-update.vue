<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="店铺名称" prop="shopName">
      <el-input v-model="dataForm.shopName" placeholder="店铺名称"></el-input>
    </el-form-item>
    <el-form-item label="店铺描述" prop="shopDesc">
      <el-input v-model="dataForm.shopDesc" placeholder="店铺描述"></el-input>
    </el-form-item>
    <el-form-item label="店铺LOGO URL" prop="logoUrl">
      <el-input v-model="dataForm.logoUrl" placeholder="店铺LOGO URL"></el-input>
    </el-form-item>
    <el-form-item label="店铺横幅 URL" prop="bannerUrl">
      <el-input v-model="dataForm.bannerUrl" placeholder="店铺横幅 URL"></el-input>
    </el-form-item>
    <el-form-item label="省份" prop="province">
      <el-input v-model="dataForm.province" placeholder="省份"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="city">
      <el-input v-model="dataForm.city" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="区域" prop="district">
      <el-input v-model="dataForm.district" placeholder="区域"></el-input>
    </el-form-item>
    <el-form-item label="详细地址" prop="detail">
      <el-input v-model="dataForm.detail" placeholder="详细地址"></el-input>
    </el-form-item>
    <el-form-item label="经度" prop="longitude">
      <el-input v-model="dataForm.longitude" placeholder="经度"></el-input>
    </el-form-item>
    <el-form-item label="纬度" prop="latitude">
      <el-input v-model="dataForm.latitude" placeholder="纬度"></el-input>
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
          shopName: '',
          shopDesc: '',
          logoUrl: '',
          bannerUrl: '',
          province: '',
          city: '',
          district: '',
          detail: '',
          longitude: '',
          latitude: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          shopName: [
            { required: true, message: '店铺名称不能为空', trigger: 'blur' }
          ],
          shopDesc: [
            { required: true, message: '店铺描述不能为空', trigger: 'blur' }
          ],
          logoUrl: [
            { required: true, message: '店铺LOGO URL不能为空', trigger: 'blur' }
          ],
          bannerUrl: [
            { required: true, message: '店铺横幅 URL不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '省份不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          district: [
            { required: true, message: '区域不能为空', trigger: 'blur' }
          ],
          detail: [
            { required: true, message: '详细地址不能为空', trigger: 'blur' }
          ],
          longitude: [
            { required: true, message: '经度不能为空', trigger: 'blur' }
          ],
          latitude: [
            { required: true, message: '纬度不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/shop/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.shopName = data.shop.shopName
                this.dataForm.shopDesc = data.shop.shopDesc
                this.dataForm.logoUrl = data.shop.logoUrl
                this.dataForm.bannerUrl = data.shop.bannerUrl
                this.dataForm.province = data.shop.province
                this.dataForm.city = data.shop.city
                this.dataForm.district = data.shop.district
                this.dataForm.detail = data.shop.detail
                this.dataForm.longitude = data.shop.longitude
                this.dataForm.latitude = data.shop.latitude
                this.dataForm.createTime = data.shop.createTime
                this.dataForm.updateTime = data.shop.updateTime
                this.dataForm.isDel = data.shop.isDel
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
              url: this.$http.adornUrl(`/eshop/shop/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'shopName': this.dataForm.shopName,
                'shopDesc': this.dataForm.shopDesc,
                'logoUrl': this.dataForm.logoUrl,
                'bannerUrl': this.dataForm.bannerUrl,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'district': this.dataForm.district,
                'detail': this.dataForm.detail,
                'longitude': this.dataForm.longitude,
                'latitude': this.dataForm.latitude,
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
