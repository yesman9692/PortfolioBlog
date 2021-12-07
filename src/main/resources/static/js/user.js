let index={
    init: function () {
        $("#btn-join").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.save();
        });
        $("#btn-login").on("click", ()=>{ //()={} 이걸 쓴 이유: this를 바인딩하기 위함.
            this.login();
        });
    },

    login: function () {
        alert("user의 login함수 호출됨");
        let data={
            username:$("#username").val(), //username이라는 변수에 id가 username인 것의 값을 찾아서 저장.
            password: $("#password").val()
        };

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"POST", //=insert
            url:"/api/user/login",
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("로그인이 완료되었습니다");
            location.href = "/";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    },

    save: function () {
        alert("user의 save함수 호출됨");
        let data={
            username:$("#username").val(), //username이라는 변수에 id가 username인 것의 값을 찾아서 저장.
            password:$("#password").val(),
            email:$("#email").val(),
        };

        console.log(data);

        //ajax호출시 default가 비동기호출.
        $.ajax({ //요청
            type:"POST", //=insert
            url:"/api/user",
            data: JSON.stringify(data), //data는 js오브젝트이므로, JSON문자열로 변환. http body데이터.
            contentType: "application/json; charset=utf-8", //body데이터가 어떤 타입인지(MIME TYPE)
            dataType:"json" //응답이 json이라면, js오브젝트로 변경해줌

        }).done(function (response){ //ajax의 리턴값이 response로 들어옴. 정상이면 실행
            alert("회원가입이 완료되었습니다");
            location.href = "/";
        }).fail(function(error){ //실패하면 fail실행
            alert(JSON.stringify(error));
        }); //ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
    }
}

index.init();

