<template>
    <div class="app-container">
        <h1>Add Teacher</h1>
        <el-form label-width="120px">
      <el-form-item label="Name">
        <el-input v-model="teacher.name"/>
      </el-form-item>
      <el-form-item label="Sort">
        <el-input-number v-model="teacher.sort" controls-position="right" :min="0"/>
      </el-form-item>
      <el-form-item label="Title">
        <el-select v-model="teacher.level" clearable placeholder="please select">
          <el-option :value="1" label="Lecturer"/>
          <el-option :value="2" label="Senior Lecturer"/>
        </el-select>
      </el-form-item>
      <el-form-item label="Career">
        <el-input v-model="teacher.career"/>
      </el-form-item>
      <el-form-item label="Introduction">
        <el-input v-model="teacher.intro" :rows="10" type="textarea"/>
      </el-form-item>

      <!-- Avatar：TODO -->

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate">Save</el-button>
      </el-form-item>
    </el-form>

    </div>
</template>
<script>
import teacher from '@/api/edu/teacher'
export default {
    data(){
        return {
            teacher:{
                name:'',
                sort:0,
                level:1,
                career:'',
                intro:'',
                avatar:''
            },
            saveBtnDisabled:false //save button disabled or not
        }
    },
    created(){
        //console.log("render")
        this.init()
    },
    methods:{
        //select teacher by id
        selectTeacherById(id){
            teacher.findTeacherById(id)
            .then(response => {
                //   return Result.success().setData("teacher", teacher);
                this.teacher = response.data.teacher
            })
        },
        saveOrUpdate(){
            //judge save or update
            if(this.teacher.id){
                this.updateTeacher()
            }else{
                this.saveTeacher()
            }
        },
        //add teacher
        saveTeacher(){
            teacher.addTeacher(this.teacher)
            .then(response => {
                //tips:add successful
                this.$message({
                type: 'success',
                message: 'added successfully!'
                });
                //back to the list
                //router redirect
                this.$router.push({path:'/teacher/table'})
            })
        },
        //update teacher
        updateTeacher(){
            teacher.updateTeacher(this.teacher)
            .then(response => {
                this.$message({
                type: 'success',
                message: 'updated successfully!'
                });
                this.$router.push({path:'/teacher/table'})
            })
        },
        init(){
            if(this.$route.params && this.$route.params.id){
            //get id
            const id = this.$route.params.id
            this.selectTeacherById(id)
            }else{
                this.teacher = {
                name:'',
                sort:0,
                level:1,
                career:'',
                intro:'',
                avatar:''
            }
            }
        }
    },
    watch:{
        $route(to,from){
            //console.log(from)
            //console.log(to)
            this.init()
        }
    }
}
</script>