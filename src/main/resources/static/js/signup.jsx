const {useState, useEffect} = React;


const Signup = () => {
    return (
        <div className={'root'}>
            <div className={'back'}></div>
            <div className={'container'}/>
            <div className={'title1'}>에브리타임 회원가입</div>

            <div className={'sub-title1'}>에브리타임 계정으로<br/>무제한으로 이용하실 수 있습니다.</div>
            <div className={'sub-title2'}>다양한 고등학생 전용 서비스</div>
            <div className={'sub-title3'}>를</div>

            <div className={'email'}>이메일</div>
            <input className={'emailInput'} placeholder={'이메일을 입력해주세요.'}/>

            <div className={'password'}>비밀번호</div>
            <input className={'passInput'} type="password" placeholder={'비밀번호를 입력해주세요.'}/>

            <div className={'school'}>고등학교</div>
            <input className={'schInput'} type="password" placeholder={'비밀번호를 입력해주세요.'}/>

            <div className={'nickname'}>닉네임</div>
            <input className={'nameInput'} type="password" placeholder={'비밀번호를 입력해주세요.'}/>

            <button className={'loginButton'}>다음</button>
        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Signup/>
);