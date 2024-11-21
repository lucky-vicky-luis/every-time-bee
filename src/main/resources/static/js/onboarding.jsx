const {useState, useEffect} = React;


const Onboarding = () => {
    return (
        <div className={'root'}>
            <div className={'container'}>
                <div className={'title'}>함께하는 학창생활,</div>
                <div className={'title'}>에브리타임</div>
                <div style={{ marginTop: 72}}></div>
                <img className={'logo'} src={'images/logo.png'}/>
                <div className={'sub-title'}>에브리타임에서</div>
                <div className={'sub-title'}>전국에 학생들과 함께</div>
                <div className={'sub-title'}>여러분의 학창생활을 함께해보아요.</div>

                <button className={'sign-in-button'}>로그인</button>
                <button className={'sign-up-button'}>에브리타임 회원가입</button>
            </div>
        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Onboarding/>
);