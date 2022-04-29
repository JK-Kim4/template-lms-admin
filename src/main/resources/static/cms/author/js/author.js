let main = {
    init : function (){
        let _this = this;

        $("#submitBtn").on("click", function(){
            _this.save();
        });
    },
    save : function (){
      console.log("save function start");

      let data = {
          name1 : $("#name1").val(),
          name2 : $("#name2").val(),
          name3 : $("#name3").val(),
          description : $("#description").val(),
          imgUrl : $("#imgUrl").val()
      }
      $.ajax({
          url : "/author/api/save",
          method : "POST",
          contentType : "application/json; charset=UTF-8",
          dataType : "json",
          data : JSON.stringify(data),
          success : function (result){
              console.log("save result : " + result)
              if(result > 0){
                  alert("등록 성공");
                  window.location.href = "/author/list"
              }else{
                  alert("등록 실패")
              }
          },
          error : function (e, x, h){
              alert("error : " +e);
          }
      })
    }
}


main.init();