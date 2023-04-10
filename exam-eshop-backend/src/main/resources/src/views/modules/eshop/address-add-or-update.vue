<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户ID" prop="uid">
      <el-input v-model="dataForm.uid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="收货人姓名" prop="realName">
      <el-input v-model="dataForm.realName" placeholder="收货人姓名"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="联系电话"></el-input>
    </el-form-item>
    <el-form-item label="省份" prop="province">
      <el-input v-model="dataForm.province" placeholder="省份"></el-input>
    </el-form-item>
    <el-form-item label="城市" prop="city">
      <el-input v-model="dataForm.city" placeholder="城市"></el-input>
    </el-form-item>
    <el-form-item label="区/县" prop="district">
      <el-input v-model="dataForm.district" placeholder="区/县"></el-input>
    </el-form-item>
    <el-form-item label="详细地址" prop="detail">
      <el-input v-model="dataForm.detail" placeholder="详细地址"></el-input>
    </el-form-item>
    <el-form-item label="邮编" prop="postCode">
      <el-input v-model="dataForm.postCode" placeholder="邮编"></el-input>
    </el-form-item>
    <el-form-item label="经度" prop="longitude">
      <el-input v-model="dataForm.longitude" placeholder="经度"></el-input>
    </el-form-item>
    <el-form-item label="纬度" prop="latitude">
      <el-input v-model="dataForm.latitude" placeholder="纬度"></el-input>
    </el-form-item>
    <el-form-item label="是否默认地址，0：否，1：是" prop="isDefault">
      <el-input v-model="dataForm.isDefault" placeholder="是否默认地址，0：否，1：是"></el-input>
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
          uid: '',
          realName: '',
          phone: '',
          province: '',
          city: '',
          district: '',
          detail: '',
          postCode: '',
          longitude: '',
          latitude: '',
          isDefault: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          uid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          realName: [
            { required: true, message: '收货人姓名不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '省份不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '城市不能为空', trigger: 'blur' }
          ],
          district: [
            { required: true, message: '区/县不能为空', trigger: 'blur' }
          ],
          detail: [
            { required: true, message: '详细地址不能为空', trigger: 'blur' }
          ],
          postCode: [
            { required: true, message: '邮编不能为空', trigger: 'blur' }
          ],
          longitude: [
            { required: true, message: '经度不能为空', trigger: 'blur' }
          ],
          latitude: [
            { required: true, message: '纬度不能为空', trigger: 'blur' }
          ],
          isDefault: [
            { required: true, message: '是否默认地址，0：否，1：是不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/address/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.uid = data.address.uid
                this.dataForm.realName = data.address.realName
                this.dataForm.phone = data.address.phone
                this.dataForm.province = data.address.province
                this.dataForm.city = data.address.city
                this.dataForm.district = data.address.district
                this.dataForm.detail = data.address.detail
                this.dataForm.postCode = data.address.postCode
                this.dataForm.longitude = data.address.longitude
                this.dataForm.latitude = data.address.latitude
                this.dataForm.isDefault = data.address.isDefault
                this.dataForm.createTime = data.address.createTime
                this.dataForm.updateTime = data.address.updateTime
                this.dataForm.isDel = data.address.isDel
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
              url: this.$http.adornUrl(`/eshop/address/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'uid': this.dataForm.uid,
                'realName': this.dataForm.realName,
                'phone': this.dataForm.phone,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'district': this.dataForm.district,
                'detail': this.dataForm.detail,
                'postCode': this.dataForm.postCode,
                'longitude': this.dataForm.longitude,
                'latitude': this.dataForm.latitude,
                'isDefault': this.dataForm.isDefault,
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
