package com.curriculum.studystar.Service.Impl.TeacherServiceImpl;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.studystar.Domain.Entity.Course;
import com.curriculum.studystar.Domain.Entity.CourseSelection;
import com.curriculum.studystar.Domain.Entity.Question;
import com.curriculum.studystar.Domain.Entity.Task;
import com.curriculum.studystar.Domain.Entity.TaskStatus;
import com.curriculum.studystar.Domain.Entity.User;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.AnswerListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.CourseEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.MessageSendRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.QuestionEditRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.StudentListRequest;
import com.curriculum.studystar.Domain.RequestAndResponse.Request.Teacher.questionitem;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.AnswerListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.CourseListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.MessageSendResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.QuestionDetailsResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.StudentListResponse;
import com.curriculum.studystar.Domain.RequestAndResponse.Response.Teacher.courseExtra1;
import com.curriculum.studystar.Mapper.CourseMapper;
import com.curriculum.studystar.Mapper.CourseSelectionMapper;
import com.curriculum.studystar.Mapper.MessageMapper;
import com.curriculum.studystar.Mapper.QuestionMapper;
import com.curriculum.studystar.Mapper.TaskMapper;
import com.curriculum.studystar.Mapper.TaskStatusMapper;
import com.curriculum.studystar.Mapper.UserMapper;
import com.curriculum.studystar.Service.TeacherService.TeacherService;
import com.curriculum.studystar.Utils.CurrentTimeUtil;
import com.curriculum.studystar.Utils.RandomUID;

@Service
public class TeacherServiceImpl implements TeacherService {
    
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired 
    CourseSelectionMapper selectMapper;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskStatusMapper taskStatusMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    QuestionMapper questionMapper;

    //获取课程列表
    public CourseListResponse CourseList(String teacherId){
        CourseListResponse resp = new CourseListResponse();
        ArrayList<Course> list = new ArrayList<Course>();

        list = courseMapper.SelectCourseByTeacherId(teacherId);
        courseExtra1 tempresp = new courseExtra1();
        int count = 0; //计数器
        //ArrayList遍历赋值
        for(Course course: list){
            count++;
            tempresp.addCourseList(course.getCourseId(), course.getCourseName(), 
                                course.getCourseLevel(), course.getCourseKey());
        }
        resp.setCode(1);
        resp.getResponse().setTotal(count);
        resp.getResponse().setList(tempresp.getList());
        return resp;
    }

    //获取学生列表
    public StudentListResponse StudentList(StudentListRequest req, String teacherId){
        StudentListResponse resp = new StudentListResponse();
        String userName = req.getUserName();
        String courseId = req.getSubjectId();
        ArrayList<User> student = new ArrayList<>();
        

        //通过课程筛选
        if(userName==null && courseId!=null){
            //课程名和老师是否匹配
            String realTeacher = courseMapper.SelectTeacherByCourseId(courseId);
            if(realTeacher.equals(teacherId)){
                resp.setCode(1);
                student = selectMapper.SelectStudentByCourseId(courseId);
                resp.getResponse().setTotal(student.size());
            }
            else{
                resp.setCode(0);
            }
            
        }
        //通过学生名筛选
        else if(userName!=null && courseId==null){
            resp.setCode(1);
            resp.getResponse().setTotal(1);
            student.add(userMapper.SelectStudentByUserName(userName));
        }
        //通过课程名+学生名筛选
        else if (userName!=null && courseId!=null){
            User tempstu = userMapper.SelectStudentByUserName(userName);
            //没找到学生
            if(tempstu.getUserId().equals(null)){
                resp.setCode(0);
            }
            //找到学生
            else{
                CourseSelection tempcour = selectMapper.SelectStudentByAll(courseId, tempstu.getUserId());
                //没找到课程
                if(tempcour.getSelectionId().equals(null)){
                    resp.setCode(0);
                }
                //找到课程
                else{
                    //课程和老师是否匹配
                    String realTeacher = courseMapper.SelectTeacherByCourseId(courseId);
                    if(realTeacher.equals(teacherId)){
                        resp.setCode(1);
                        resp.getResponse().setTotal(1);
                        student.add(tempstu);
                    }
                    else{
                        resp.setCode(0);
                    }
    
                }
            }
        }
        //无筛选条件
        else if(userName==null && courseId==null){
            //禁止无筛选条件
            resp.setCode(0);
        }

        resp.getResponse().setList(student);
        return resp;
    }

    //获取答卷列表
    public AnswerListResponse AnswerList(AnswerListRequest req, String teacherId){
        AnswerListResponse answerlistresp = new AnswerListResponse();
        String courseId = req.getSubjectId();
        String taskId = req.getExamId();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<TaskStatus> taskStatus = new ArrayList<>();
        int count = 0;

        //通过课程id筛选
        if(courseId!=null && taskId==null){
            //通过教师id和课程id查询出所有的课程
            Course mycourse = new Course();
            mycourse = courseMapper.SelectCourseByTeacherIdAndCourseId(courseId, teacherId);
            if(mycourse == null){
                answerlistresp.setCode(0);
                answerlistresp.setMessage("抱歉，未查询到您的授课信息！");
            }
            else{
                tasks = taskMapper.SelectTaskByCourseId(courseId);
                for(Task t : tasks){
                    taskStatus = taskStatusMapper.SelectTaskStatusByTaskId(t.getTaskId());
                    for(TaskStatus ts : taskStatus){
                        count++;
                        User u = userMapper.SelectUserByUserId(ts.getStudentId());
                        answerlistresp.getResponse().addData(t.getTaskId(),
                                                             t.getCreateTime(),
                                                             ts.getTotalScore(),
                                                             t.getScore(),
                                                             null,
                                                             t.getType(),
                                                             0,
                                                             ts.getStatus(),
                                                             t.getTaskName(),
                                                             u.getRealName()); 
                        
                    }
                }
                answerlistresp.setCode(1);
                answerlistresp.setMessage("按照课程名检索成功！");
                answerlistresp.getResponse().setTotal(count);
            }
        }
        //通过试卷id筛选
        else if(courseId==null && taskId!=null){
            //通过taskId查出对应的课程
            String mycourseid = taskMapper.SelectCourseIdByTaskId(taskId);
            Course mycourse = courseMapper.SelectCourseByCourseId(mycourseid);

            ArrayList<Course> teachcourse = new ArrayList<>();
            teachcourse = courseMapper.SelectCourseByTeacherId(teacherId);

            if(teachcourse.contains(mycourse)){
                Task t = taskMapper.SelectTaskByTaskId(taskId);
                taskStatus = taskStatusMapper.SelectTaskStatusByTaskId(taskId);
                for(TaskStatus ts : taskStatus){
                    count++;
                    User u = userMapper.SelectUserByUserId(ts.getStudentId());
                    answerlistresp.getResponse().addData(taskId,
                                                         t.getCreateTime(),
                                                         ts.getTotalScore(),
                                                         t.getScore(),
                                                         null,
                                                         t.getType(),
                                                         0,
                                                         ts.getStatus(),
                                                         t.getTaskName(),
                                                         u.getRealName()); 
                }
                answerlistresp.setCode(1);
                answerlistresp.setMessage("按照试卷名检索成功！");
                answerlistresp.getResponse().setTotal(count);
            }
            else{
                answerlistresp.setCode(0);
                answerlistresp.setMessage("抱歉，未查询到您的授课信息！");
            }
        }
        //通过课程id+试卷id筛选
        else if(courseId!=null && taskId!=null){
            //课程和试卷是否匹配
            //id匹配
            if(courseId.equals(taskMapper.SelectCourseIdByTaskId(taskId))){
                //检测对应试卷的课程与老师是否匹配
                String realTeacher = courseMapper.SelectTeacherByCourseId(courseId);
                //匹配
                if(realTeacher.equals(teacherId)){
                    Task t = taskMapper.SelectTaskByTaskId(taskId);
                    taskStatus = taskStatusMapper.SelectTaskStatusByTaskId(taskId);
                    for(TaskStatus ts : taskStatus){
                        count++;
                        User u = userMapper.SelectUserByUserId(ts.getStudentId());
                        answerlistresp.getResponse().addData(taskId,
                                                            t.getCreateTime(),
                                                            ts.getTotalScore(),
                                                            t.getScore(),
                                                            null,
                                                            t.getType(),
                                                            0,
                                                            ts.getStatus(),
                                                            t.getTaskName(),
                                                            u.getRealName()); 
                    }
                    answerlistresp.setCode(1);
                    answerlistresp.setMessage("按照试卷名检索成功！");
                    answerlistresp.getResponse().setTotal(count);
                }
                //不匹配
                else{
                    answerlistresp.setCode(0);
                    answerlistresp.setMessage("抱歉，未查询到您的授课信息！");
                }
            }
            //id不匹配
            else{
                answerlistresp.setCode(0);
                answerlistresp.setMessage("课程与试卷不相符！");
            }
        }
        //无筛选条件，默认展示
        else if(courseId==null && taskId==null){
            courses = courseMapper.SelectCourseByTeacherId(teacherId);
            for(Course c : courses){
                tasks = taskMapper.SelectTaskByCourseId(c.getCourseId());
                for(Task t : tasks){
                    taskStatus = taskStatusMapper.SelectTaskStatusByTaskId(t.getTaskId());
                    for(TaskStatus ts : taskStatus){
                        count++;
                        User u = userMapper.SelectUserByUserId(ts.getStudentId());
                        answerlistresp.getResponse().addData(taskId,
                                                            t.getCreateTime(),
                                                            ts.getTotalScore(),
                                                            t.getScore(),
                                                            null,
                                                            t.getType(),
                                                            0,
                                                            ts.getStatus(),
                                                            t.getTaskName(),
                                                            u.getRealName());
                    }
                }
            }
            answerlistresp.setCode(1);
            answerlistresp.setMessage("默认索引成功！");
            answerlistresp.getResponse().setTotal(count);
        }

        return answerlistresp;
    }

    //编辑课程
    public void CourseEdit(CourseEditRequest req, String teacherId){
        //判断课程id是否为空
        //为空需要新建课程
        if(req.getId()==null){
            String newid = RandomUID.getRandomUID();
            int newlevel = req.getLevel();
            String newname = req.getName();
            String newimage = null;
            courseMapper.InsertNewCourse(newid, newimage, newid, newlevel, newname, teacherId);
        }
        //不为空则更新课程
        else{
            String id = req.getId();
            String updataname = req.getName();
            int updatelevel = req.getLevel();
            courseMapper.UpdataCourse(updatelevel, updataname, id);
        }
    }

    //课程详情
    public CourseDetailsResponse CourseDetails(String id){
        CourseDetailsResponse deatilresp = new CourseDetailsResponse();
        Course curcourse = courseMapper.SelectCourseByCourseId(id);
        if(curcourse!=null){
            deatilresp.setId(id);
            deatilresp.setLevel(curcourse.getCourseLevel());
            deatilresp.setName(curcourse.getCourseName());
        }
    
        return deatilresp;
    }

    //发送消息
    public MessageSendResponse SendMessage(MessageSendRequest req, String teacherId){
        MessageSendResponse messresp = new MessageSendResponse();
        ArrayList<String> tostudents = new ArrayList<>();
        tostudents = req.getReceiveUserIds();
        
        //发送对象为空
        if(tostudents.isEmpty()){
            messresp.setCode(0);
        }
        //发送对象不为空
        else{
            for(String m : tostudents){
                String messgaeid = RandomUID.getRandomUID();
                String content = req.getContent();
                int read = 0;
                String receiver = m;
                String sender = teacherId;
                String title = req.getTitile();
                String time = CurrentTimeUtil.getCurrnetTime();

                messageMapper.InsertMessage(messgaeid, content, read, receiver, time, sender, title);
            }
            messresp.setCode(1);
        }

        return messresp;
    }

    //编辑题目
    public void EditQuestion(QuestionEditRequest req){
        //判断题目id是否为空
        //为空新建题目
        if(req.getId()==null){
            String newid = RandomUID.getRandomUID();
            String answer=null;
            String options=null;
            String chapter = null;
            String questionFile = null;
            //4、2-array，5、3、1-correct
            //答案
            if(req.getQuestionType()==4 ||req.getQuestionType()==2){
                int count = 0;
                for(String s : req.getCorrectArray()){
                    count++;
                    if(count>1&&count<=req.getItems().size()){
                        answer = answer +"$"+ s;
                    }
                    else{
                        answer = answer + s;
                    }
                }
            }
            else{
                answer = req.getCorrect();
            }
            //选项
            if(req.getQuestionType()==1 ||req.getQuestionType()==2||req.getQuestionType()==3){
                int count = 0;
                for(questionitem i : req.getItems()){
                    count++;
                    options = options + i.getPrefix()+ "$" + i.getContent();
                    if(count<=req.getItems().size()-1){
                        options = options + "@";
                    }
                }
            }

            questionMapper.InsertQuestion(newid, req.getAnalyse(), answer, chapter, req.getSubjectId(), req.getTitle(), req.getDifficult(), options, req.getQuestionType(), questionFile, req.getScore());
        }
        //不为空则更新题目
        else{
            String answer=null;
            String options=null;
            //答案
            if(req.getQuestionType()==4 ||req.getQuestionType()==2){
                for(String s : req.getCorrectArray()){
                    answer = answer + s;
                }
            }
            else{
                answer = req.getCorrect();
            }
            //选项
            if(req.getQuestionType()==1 ||req.getQuestionType()==2||req.getQuestionType()==3){
                int count = 0;
                for(questionitem i : req.getItems()){
                    count++;
                    options = options + i.getPrefix()+ "$" + i.getContent();
                    if(count<=req.getItems().size()-1){
                        options = options + "@";
                    }
                }
            }

            questionMapper.UpdataQuestion(req.getAnalyse(), answer, req.getTitle(), req.getDifficult(), options, req.getQuestionType(), req.getScore(),req.getId());
        }

        
    }

    //题目详情
    public QuestionDetailsResponse QuestionDetail(String id){
        QuestionDetailsResponse resp = new QuestionDetailsResponse();
        Question current = new Question();

        current = questionMapper.SelectQuestionByQuestionId(id);
        resp.getResponse().setId(current.getQuestionId());
        resp.getResponse().setQuestionType(current.getQuestionType());
        resp.getResponse().setSubjectId(current.getCourseId());
        resp.getResponse().setTitle(current.getDescription());
        resp.getResponse().setGradeLevel(1);
        resp.getResponse().setAnalyze(current.getAnalysis());
        resp.getResponse().setDifficult(current.getDifficult());
        resp.getResponse().setScore(current.getScore());

        String answerStr = current.getAnswer();
        String[] answer = answerStr.split("\\$");
        for(int i=0;i<answer.length;i++){
            resp.getResponse().addList(answer[i]);
        }   

        String options = current.getOptions();
        if(options!=null){
            String[] items = options.split("@");
            for(String item : items){
                String[] questionItem = item.split("\\$");
                resp.getResponse().addItem(questionItem[0], questionItem[1]);
            } 
        }
           
        return resp;
    }
}
/*
 * @Autowired
    UserMapper userMapper;
    @Autowired
    LogMapper logMapper;

    @Override
    public LoginResponse Login(LoginRequest req){
        LoginResponse resp = new LoginResponse();
        String username = req.getUsername();
        String password = req.getPassword();
        Integer role = req.getRole();

        User user = userMapper.SelectUserByUserName(username);
 */