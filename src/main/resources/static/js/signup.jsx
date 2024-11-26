const { useState } = React;
const axios = window.axios; // 전역에서 Axios 사용

const Signup = () => {
        const [email, setEmail] = useState('');
        const [password, setPassword] = useState('');
        const [nickname, setNickname] = useState('');

        const handleSignup = async () => {
                try {
                        const response = await axios.post('/user', {
                                email: email,
                                password: password,
                                nickname: nickname,
                        });

                        if (response.status === 200) {
                                alert('회원가입 성공!');
                                window.location.href = '/login';
                        } else {
                                alert('회원가입 실패: 다시 시도해주세요.');
                        }
                } catch (error) {
                        console.error('회원가입 오류:', error);
                        alert('회원가입 중 문제가 발생했습니다.');
                }
        };

        return (
            <div className={'root'}>
                    <div className={'back'}></div>
                    <div className={'container'} />
                    <div className={'title1'}>에브리타임 회원가입</div>

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

                    <div className={'nickname'}>닉네임</div>
                    <input
                        className={'nameInput'}
                        placeholder={'닉네임을 입력해주세요.'}
                        value={nickname}
                        onChange={(e) => setNickname(e.target.value)}
                    />

                    <button className={'loginButton'} onClick={handleSignup}>
                            다음
                    </button>
            </div>
        );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Signup />);
