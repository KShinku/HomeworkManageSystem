/**
 * Created by 东旭 on 2017/5/5.
 */
window.onload = function () {
    $("#mask").fadeOut();
    var nav_sidebar=$.ajax({
        url:"/sidebar",
        type:"GET",
        async:false
    });
    $("#sidebar").html(nav_sidebar.responseText);
    getHomepage();
};

$("#logout").click(function(){
    $.get("/logout");
    $("html").fadeOut();
    setTimeout("window.location.reload();",500);
});

var getHomepage=function () {
    var homepage=$.ajax({
        url:"/homepage",
        type:"GET",
        async:false
    });
    $("#main-content").html(homepage.responseText);
};

var getHomework=function () {
    var homework=$.ajax({
        url:"/homework",
        type:"GET",
        async:false
    });
    $("#main-content").html(homework.responseText);
};

var getAnswerpage=function(e){
    var Answerpage=$.ajax({
        url:"/answerpage",
        type:"GET",
        data:{
            question_id:e.id
        },
        async:false
    });
    $("#main-content").html(Answerpage.responseText);
};

var submitAnswer=function (e) {
    var submit_result=$.ajax({
        url:"/submit-answer",
        type:"PUT",
        data:{
            question_id:e.id,
            answer:$("#answer").val()
        },
        async:false
    });
    alert(submit_result.responseText);
    getHomework();
};

var getClasspage=function (e) {
    var classpage=$.ajax({
        url:"/classes",
        type:"GET",
        data:{
            class_id:e.id
        },
        async:false
    });
    $("#main-content").html(classpage.responseText);
};

var getQuestionpage=function () {
    var questionpage=$.ajax({
        url:"/questions",
        type:"GET",
        async:false
    });
    $("#main-content").html(questionpage.responseText);
};

var getAddQuestionpage=function () {
    var addquestionpage=$.ajax({
        url:"/addquestion",
        type:"GET",
        async:false
    });
    $("#main-content").html(addquestionpage.responseText);
};

var addQuestion=function () {
    var add_result=$.ajax({
        url:"/question/add",
        type:"POST",
        data:{
            title:$("#title").val(),
            description:$("#description").val()
        },
        async:false
    });
    alert(add_result.responseText);
    getQuestionpage();
}

var deleteQuestion=function (e) {
    var delete_result=$.ajax({
        url:"/question/delete",
        type:"POST",
        data:{
            question_id:e.id //e.id通过下面的alert测试证实不为空
        },
        async:false
    });
    alert(delete_result.responseText);
    getQuestionpage();
}

var getEditQuestionpage=function (e) {
    var editquestionpage=$.ajax({
        url:"/editquestion",
        type:"GET",
        data:{
          question_id:e.id
        },
        async:false
    });
    $("#main-content").html(editquestionpage.responseText);
};

var editQuestion=function (e) {
    var edit_result=$.ajax({
        url:"/question/edit",
        type:"POST",
        data:{
            question_id:e.id,
            title:$("#title").val(),
            description:$("#description").val()
        },
        async:false
    });
    alert(edit_result.responseText);
    getQuestionpage();
};

var getListspage=function () {
    var listspage=$.ajax({
        url:"/lists",
        type:"GET",
        async:false
    });
    $("#main-content").html(listspage.responseText);
};

var getAddListpage=function () {
    var addlistpage=$.ajax({
        url:"/addlist",
        type:"GET",
        async:false
    });
    $("#main-content").html(addlistpage.responseText);
};

var addList=function () {
    //获取复选框题目列表
    var question_list=new Array();
    $("input[name='question_id']:checked").each(function(){
        question_list.push($(this).val());//向数组中添加元素
    });

    var add_result=$.ajax({
        url:"/list/add",
        type:"POST",
        data:{
            list_name:$("#list_name").val(),
            description:$("#description").val(),
            class_id:$("#class_id").val(),
            question_id_list:question_list.join()
        },
        async:false
    });
    alert(add_result.responseText);
    getListspage();
};

var deleteList=function (e) {
    var delete_result=$.ajax({
        url:"/list/delete",
        type:"POST",
        data:{
            list_question_id:e.id
        },
        async:false
    });
    alert(delete_result.responseText);
    getListspage()
};