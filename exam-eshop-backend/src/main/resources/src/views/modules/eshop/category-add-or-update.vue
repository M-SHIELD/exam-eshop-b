<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="分类名" prop="cname">
      <el-input v-model="dataForm.cname" placeholder="分类名"></el-input>
    </el-form-item>
    <el-form-item label="等级" prop="level">
      <el-input v-model="dataForm.level" placeholder="等级"></el-input>
    </el-form-item>
    <el-form-item label="父id" prop="parentId">
      <el-input v-model="dataForm.parentId" placeholder="父id"></el-input>
    </el-form-item>
    <el-form-item label="图片地址（头图或分类图片）" prop="imgUrl">
      <el-input v-model="dataForm.imgUrl" placeholder="图片地址（头图或分类图片）"></el-input>
    </el-form-item>
    <el-form-item label="是否展示1是0否" prop="isShow">
      <el-input v-model="dataForm.isShow" placeholder="是否展示1是0否"></el-input>
    </el-form-item>
    <el-form-item label="是否删除" prop="isDel">
      <el-input v-model="dataForm.isDel" placeholder="是否删除"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
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
          cname: '',
          level: '',
          parentId: '',
          imgUrl: '',
          isShow: '',
          isDel: '',
          createTime: '',
          updateTime: '',
          sort: ''
        },
        dataRule: {
          cname: [
            { required: true, message: '分类名不能为空', trigger: 'blur' }
          ],
          level: [
            { required: true, message: '等级不能为空', trigger: 'blur' }
          ],
          parentId: [
            { required: true, message: '父id不能为空', trigger: 'blur' }
          ],
          imgUrl: [
            { required: true, message: '图片地址（头图或分类图片）不能为空', trigger: 'blur' }
          ],
          isShow: [
            { required: true, message: '是否展示1是0否不能为空', trigger: 'blur' }
          ],
          isDel: [
            { required: true, message: '是否删除不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/category/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cname = data.category.cname
                this.dataForm.level = data.category.level
                this.dataForm.parentId = data.category.parentId
                this.dataForm.imgUrl = data.category.imgUrl
                this.dataForm.isShow = data.category.isShow
                this.dataForm.isDel = data.category.isDel
                this.dataForm.createTime = data.category.createTime
                this.dataForm.updateTime = data.category.updateTime
                this.dataForm.sort = data.category.sort
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
              url: this.$http.adornUrl(`/eshop/category/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'cname': this.dataForm.cname,
                'level': this.dataForm.level,
                'parentId': this.dataForm.parentId,
                'imgUrl': this.dataForm.imgUrl,
                'isShow': this.dataForm.isShow,
                'isDel': this.dataForm.isDel,
                'createTime': this.dataForm.createTime,
                'updateTime': this.dataForm.updateTime,
                'sort': this.dataForm.sort
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
