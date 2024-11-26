const { useState, useEffect } = React;

const Main = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        // 로그인 여부 확인 (예: JWT 토큰 또는 세션 정보 확인)
        const token = localStorage.getItem('authToken'); // 로컬 스토리지에 저장된 토큰 확인
        if (token) {
            setIsLoggedIn(true); // 로그인 상태로 설정
        }
    }, []);

    const handleLogout = () => {
        // 로그아웃 처리
        localStorage.removeItem('authToken'); // 저장된 토큰 제거
        setIsLoggedIn(false); // 로그인 상태 초기화
        alert('로그아웃 되었습니다.');
        window.location.href = '/login'; // 로그인 페이지로 리디렉션
    };

    const goToMyArticle = () => {
        window.location.href = '/myarticle'; // 로그인 페이지로 리디렉션
    }

    const goToAllArticle  = () => {
        window.location.href = '/allarticle'; // 로그인 페이지로 리디렉션
    }

    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'logo'} src={'images/logo.png'} />

                {/* 로그아웃 버튼은 로그인 상태일 때만 표시 */}
                {isLoggedIn && (
                    <button className={'logout'} onClick={handleLogout}>
                        로그아웃
                    </button>
                )}

                <img className={'profile'} src={'images/profile.svg'} />
                <img className={'search'} src={'images/search.svg'} />

                <div className={'school'}>대구소프트웨어마이스터고</div>
                <div className={'myArticle'} onClick={goToMyArticle}>
                    <div className={'myArticleTitle'}  >내가 작성한 글</div>
                    <div className={'myArticleContent'}>
                        본인이 작성한 글을 확인하고
                        <br />
                        관리해요!
                    </div>
                    <div className={'moreMyArticle'}>더보기</div>
                    <img className={'myArticleArrow'} src={'images/arrow.svg'} />
                </div>

                <div className={'newArticle'}>방금 올라온 글</div>
                <div className={'moreNewArticle'} onClick={goToAllArticle}>더보기</div>
                <img className={'newArticleArrow'} src={'images/arrow.svg'} onClick={goToAllArticle}/>
                <div className={'newArticleContainer'}>
                    <div className={'newArticleBox'}>
                        <div className={'nickname'}>닉네임</div>
                        <div className={'title'}>
                            그래서 님들 어케됨? 신설 되는거임?
                        </div>
                        <img className={'new'} src={'images/new.svg'} />
                    </div>
                </div>
            </div>
        </div>
    );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Main />);
