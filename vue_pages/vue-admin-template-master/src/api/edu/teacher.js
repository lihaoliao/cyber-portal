import request from '@/utils/request' //引入utils中的request

export default {
    //conditional Pagination Select Teacher
    getTeacherListPage(cur,size,teacherVO)    {
        return request({
          url: `/eduservice/teacher/conditionalPaginationSelect/${cur}/${size}`,
          method: 'post',
          //条件对象,后端使用@RequestBody获取,data表示将对象转换成json传递到接口中
          //Conditional object, back-end use @RequestBody to get
          data:teacherVO
        })
      },
    
      //delete teacher
      removeTeacher(id){
          return request({
            url:`/eduservice/teacher/removeTeacher/${id}`,
            method:`delete`,
            param:id
          })
      },
      //add teacher
      addTeacher(teacher){
        return request({
          url:`/eduservice/teacher/addTeacher`,
          method:`post`,
          data:teacher
        })
      },
      //select teacher by id
      findTeacherById(id){
        return request({
          url:`/eduservice/teacher/findTeacherById/${id}`,
          method:`get`,
        })
      },
      //update teacher
      updateTeacher(teacher){
        return request({
          url:`/eduservice/teacher/updateTeacher`,
          method:`post`,
          data:teacher
        })
      }

}

