const { useState } = React;
const axios = window.axios; // 전역에서 Axios 사용

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            // Axios로 로그인 요청
            const response = await axios.post('/auth/signin', {
                email: email,
                password: password,
            });

            if (response.status === 200) {
                alert('로그인 성공!');
                // 로그인 성공 시 /main으로 리디렉션
                window.location.href = '/main';
            }
        } catch (error) {
            console.error('로그인 오류:', error);
            alert('로그인 실패: 이메일 또는 비밀번호를 확인하세요.');
        }
    };

    return (
        <div className={'root'}>
            <div className={'back'}></div>
            <div className={'container'} />
            <div className={'title1'}>에브리타임 로그인</div>
            <div className={'sub-title1'}>
                에브리타임 계정으로<br />무제한으로 이용하실 수 있습니다.
            </div>
            <div className={'sub-title2'}>다양한 고등학생 전용 서비스</div>
            <div className={'sub-title3'}>를</div>

            <div className={'email'}>이메일</div>
            <input
                className={'emailInput'}
                placeholder={'이메일을 입력해주세요.'}
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <div className={'password'}>비밀번호</div>
            <input
                className={'passInput'}
                type="password"
                placeholder={'비밀번호를 입력해주세요.'}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <div
                className={'toSignup'}
                onClick={() => window.location.href = '/signup'}
                style={{ cursor: 'pointer', color: 'blue' }}
            >
                회원가입하기
            </div>

            <button className={'loginButton'} onClick={handleLogin}>
                로그인
            </button>
        </div>
    );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Login />);
