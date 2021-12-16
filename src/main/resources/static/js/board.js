let jobIndex={
    init: function () {
        $("#btn-job-save").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.jobsave();
        });
        $("#job-btn-delete").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.jobDelete();
        });
        $("#btn-job-update").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.jobUpdate();
        });
    },

    jobsave: function () {
        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        // console.log(data);

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"POST", //=insert
            url:"/api/jobBoard",
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("글쓰기가 완료되었습니다");
            location.href = "/board/jobBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    jobDelete: function () {
        let id = $("#id").text();
        // console.log("jobDelete: id=" + id);
        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"DELETE", //=insert
            url:"/api/jobBoard/"+id,
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("삭제가 완료되었습니다");
            location.href = "/board/jobBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    jobUpdate: function () {
        let id = $("#jobId").val();

        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        console.log("jobUpdate:" + data);

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"PUT", //=insert
            url:"/api/jobBoard/" + id,
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("글 수정이 완료되었습니다");
            location.href = "/board/jobBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    }
}

let socialIndex={
    init: function () {
        $("#btn-social-save").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.socialsave();
        });
        $("#social-btn-delete").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.socialDelete();
        });
        $("#btn-social-update").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.socialUpdate();
        });
    },

    socialsave: function () {
        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        // console.log(data);

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"POST", //=insert
            url:"/api/socialBoard",
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("글쓰기가 완료되었습니다");
            location.href = "/board/socialBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    socialDelete: function () {
        var id = $("#id").text();
        // console.log("socialDelete: id=" + id);
        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"DELETE", //=insert
            url:"/api/socialBoard/"+id,
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("삭제가 완료되었습니다");
            location.href = "/board/socialBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    socialUpdate: function () {
        let id = $("#socialId").val();

        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        console.log(data);

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"PUT", //=insert
            url:"/api/socialBoard/" + id,
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("글 수정이 완료되었습니다");
            location.href = "/board/socialBoard";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    }
}

jobIndex.init();
socialIndex.init();


