<template>
    <div class="app-container">
        <h1>Teacher List</h1>
         <!--查询表单-->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="teacherVO.name" placeholder="Name"/>
      </el-form-item>

      <el-form-item>
        <el-select v-model="teacherVO.level" clearable placeholder="Title">
          <el-option :value="1" label="Lecturer"/>
          <el-option :value="2" label="Senior Lecturer"/>
        </el-select>
      </el-form-item>

      <el-form-item label="Create Time">
        <el-date-picker
          v-model="teacherVO.begin"
          type="datetime"
          placeholder="Select start time"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        />
      </el-form-item>
      <el-form-item>
        <!-- 时间选择框 -->
        <el-date-picker
          v-model="teacherVO.end"
          type="datetime"
          placeholder="Select end time"
          value-format="yyyy-MM-dd HH:mm:ss"
          default-time="00:00:00"
        /> 
      </el-form-item>

      <el-button type="primary" icon="el-icon-search" @click="getList()">Select</el-button>
      <el-button type="default" @click="resetData()">Clear</el-button>
    </el-form>

    <!-- 表格 -->
    <el-table
      :data="list"
      border
      fit
      highlight-current-row>

      <el-table-column
        label="Id"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (cur - 1) * size + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="name" label="Name" width="80" />

      <el-table-column label="Level" width="73">
        <template slot-scope="scope">
          {{ scope.row.level===1?'Lecturer':'Senior Lecturer' }}
        </template>
      </el-table-column>

      <el-table-column prop="intro" label="Introduction" />

      <el-table-column prop="gmtCreate" label="Create Time" width="160"/>

      <el-table-column prop="sort" label="Sort" width="60" />

      <el-table-column label="Operation" width="200" align="center">
        <template slot-scope="scope">
          <router-link :to="'/teacher/edit/'+scope.row.id">
            <el-button type="primary" size="mini" icon="el-icon-edit">Update</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeTeacherById(scope.row.id,scope.row.name)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

  <!-- 分页 -->
    <el-pagination
      :current-page="cur"
      :page-size="size"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getList"
    />

    </div>
</template>
<script>
//import teacher.js file
import teacher from '@/api/edu/teacher'
export default{
    //core code
    data(){ //定义变量和初始值
        return{
            list:null, //查询之后接口返回集合
            cur:1,
            size:5,
            total:0,
            teacherVO:{
              name:'',
              level:'',
              begin:'',
              end:''
            }
        }
    },
    created(){ //页面渲染之前执行，一般调用在methods中定义的方法
        this.getList()
    },
    methods:{ //创建具体的方法，调用teacher.js定义的方法
        //讲师列表的方法
        getList(page = 1){
            this.cur = page
            teacher.getTeacherListPage(this.cur,this.size,this.teacherVO)
            .then(response => {
                //console.log(response)
                this.list = response.data.rows
                this.total = response.data.total
                //console.log(this.list)
                //console.log(this.total)
            })
        },
        resetData(){
          this.teacherVO = {}
          this.getList()
        },
        removeTeacherById(id,name){
          this.$confirm(`This operation will delete the teacher ${name}, does it continue?`, 'Tip', {
          confirmButtonText: 'confirm',
          cancelButtonText: 'cancel',
          type: 'warning'
        })
              .then(() => {   //confirm
                teacher.removeTeacher(id)
                .then(response => {
                //console.log(id)
                this.$message({
                type: 'success',
                message: 'Deleted successfully!'
                });
                this.getList()
                })
            })
            .catch(error => { //cancel
                this.$message({
                type: 'info',
                message: `Cancel`
            }); 
            })
          
        }
    }

}
</script>