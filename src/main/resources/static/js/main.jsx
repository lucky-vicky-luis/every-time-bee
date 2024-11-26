const { useState, useEffect } = React;

const Main = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [nickname, setNickname] = useState('');  // 사용자 닉네임 상태
    const [title, setTitle] = useState('');        // 게시글 제목 상태
    const [loading, setLoading] = useState(true);  // 로딩 상태
    const [posts, setPosts] = useState([]);        // 게시글 목록 상태

    // 페이지 로드 시, 로컬 스토리지에서 로그인 상태를 확인
    useEffect(() => {
        const token = localStorage.getItem('authToken');
        if (token) {
            setIsLoggedIn(true); // 로그인 상태 설정
            fetchUserData(); // 로그인 상태가 확인되면 사용자 데이터 가져오기
            fetchPosts();     // 게시글 목록 불러오기
        } else {
            handleLogin(); // 로그인 상태를 설정하는 함수 호출
        }
    }, []);

    // 사용자 데이터를 가져오는 함수 (nickname, title 등)
    const fetchUserData = async () => {
        try {
            const response = await fetch('/api/user/data', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('authToken')}`,
                },
            });

            if (response.ok) {
                const data = await response.json();
                setNickname(data.nickname);  // 응답에서 닉네임 설정
                setTitle(data.title);        // 응답에서 제목 설정
            } else {
                console.error('사용자 데이터를 가져오는 데 실패했습니다.');
                setNickname('닉네임');
                setTitle('제목');
            }
        } catch (error) {
            console.error('사용자 데이터를 가져오는 중 오류가 발생했습니다:', error);
            setNickname('닉네임');
            setTitle('제목');
        } finally {
            setLoading(false); // 데이터 로딩 완료
        }
    };

    // 게시글 목록을 가져오는 함수
    const fetchPosts = async () => {
        try {
            const response = await fetch('/post/list', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${localStorage.getItem('authToken')}`,
                },
            });

            if (response.ok) {
                const data = await response.json();
                setPosts(data.data); // 게시글 목록을 상태에 저장
            } else {
                console.error('게시글 목록을 불러오는 데 실패했습니다.');
            }
        } catch (error) {
            console.error('게시글 목록을 가져오는 중 오류가 발생했습니다:', error);
        }
    };

    // 로그아웃 처리
    const handleLogout = async () => {
        try {
            const response = await fetch('/logout', {
                method: 'GET',
                credentials: 'same-origin', // 쿠키를 포함하여 요청
            });

            if (response.ok) {
                // 로그아웃 성공
                localStorage.removeItem('authToken'); // 로컬 스토리지에서 토큰 제거
                setIsLoggedIn(false); // 로그인 상태 변경
                window.location.href = '/login'; // 로그인 페이지로 리디렉션
            } else {
                alert('로그아웃에 실패했습니다.');
            }
        } catch (error) {
            console.error('로그아웃 중 오류가 발생했습니다:', error);
            alert('로그아웃 중 오류가 발생했습니다.');
        }
    };

    // 로그인 처리
    const handleLogin = () => {
        // 예시로 로그인 처리 (실제 API 호출로 변경해야 함)
        localStorage.setItem('authToken', 'example-token'); // 예시 토큰 저장
        setIsLoggedIn(true); // 로그인 상태 변경
    };

    const goToMyArticle = () => {
        window.location.href = '/myarticle'; // 내가 작성한 글 페이지로 리디렉션
    };

    const goToAllArticle = () => {
        window.location.href = '/allarticle'; // 모든 글 페이지로 리디렉션
    };

    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'logo'} src={'images/logo.png'} />

                {/* 로그인 상태에 관계없이 항상 표시되는 프로필, 검색 등 */}
                <img className={'profile'} src={'images/profile.svg'} />
                <img className={'search'} src={'images/search.svg'} />

                <div className={'school'}>대구소프트웨어마이스터고</div>
                <div className={'myArticle'} onClick={goToMyArticle}>
                    <div className={'myArticleTitle'}>내가 작성한 글</div>
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
                        {/* 로딩 상태가 아닐 때만 데이터 표시 */}
                        {loading ? (
                            <div>로딩 중...</div>  // 로딩 중일 때 표시
                        ) : (
                            <>
                                {/* 사용자 정보 */}
                                <div className={'nickname'}>{nickname}</div> {/* 동적으로 변경되는 닉네임 */}
                                <div className={'title'}>{title}</div> {/* 동적으로 변경되는 제목 */}

                                {/* 게시글 목록 표시 */}
                                {posts.length > 0 ? (
                                    posts.map((post) => (
                                        <div key={post.id}>
                                            <div className={'postTitle'}>{post.title}</div>
                                            <div className={'postContent'}>{post.content}</div>
                                        </div>
                                    ))
                                ) : (
                                    <div>.</div>
                                )}
                            </>
                        )}
                        <img className={'new'} src={'images/new.svg'} />
                    </div>
                </div>

                {/* 로그인 상태에 따른 로그아웃 버튼 */}
                {isLoggedIn && (
                    <button className={'logout'} onClick={handleLogout}>
                        로그아웃
                    </button>
                )}
            </div>
        </div>
    );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Main />);
