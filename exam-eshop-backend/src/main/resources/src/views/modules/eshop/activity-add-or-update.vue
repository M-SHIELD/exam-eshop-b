<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="活动名称" prop="activityName">
      <el-input v-model="dataForm.activityName" placeholder="活动名称"></el-input>
    </el-form-item>
    <el-form-item label="活动描述" prop="activityDesc">
      <el-input v-model="dataForm.activityDesc" placeholder="活动描述"></el-input>
    </el-form-item>
    <el-form-item label="活动类型，0-普通活动，1-秒杀活动，2-团购活动" prop="activityType">
      <el-input v-model="dataForm.activityType" placeholder="活动类型，0-普通活动，1-秒杀活动，2-团购活动"></el-input>
    </el-form-item>
    <el-form-item label="活动开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="活动开始时间"></el-input>
    </el-form-item>
    <el-form-item label="活动结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="活动结束时间"></el-input>
    </el-form-item>
    <el-form-item label="活动状态，0-未开始，1-进行中，2-已结束" prop="status">
      <el-input v-model="dataForm.status" placeholder="活动状态，0-未开始，1-进行中，2-已结束"></el-input>
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
          activityName: '',
          activityDesc: '',
          activityType: '',
          startTime: '',
          endTime: '',
          status: '',
          createTime: '',
          updateTime: '',
          isDel: ''
        },
        dataRule: {
          activityName: [
            { required: true, message: '活动名称不能为空', trigger: 'blur' }
          ],
          activityDesc: [
            { required: true, message: '活动描述不能为空', trigger: 'blur' }
          ],
          activityType: [
            { required: true, message: '活动类型，0-普通活动，1-秒杀活动，2-团购活动不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '活动开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '活动结束时间不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '活动状态，0-未开始，1-进行中，2-已结束不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/eshop/activity/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.activityName = data.activity.activityName
                this.dataForm.activityDesc = data.activity.activityDesc
                this.dataForm.activityType = data.activity.activityType
                this.dataForm.startTime = data.activity.startTime
                this.dataForm.endTime = data.activity.endTime
                this.dataForm.status = data.activity.status
                this.dataForm.createTime = data.activity.createTime
                this.dataForm.updateTime = data.activity.updateTime
                this.dataForm.isDel = data.activity.isDel
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
              url: this.$http.adornUrl(`/eshop/activity/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'activityName': this.dataForm.activityName,
                'activityDesc': this.dataForm.activityDesc,
                'activityType': this.dataForm.activityType,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
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
