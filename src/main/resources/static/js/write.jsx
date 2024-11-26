const { useState } = React;

const Write = () => {
    const [title, setTitle] = useState('');  // 제목 상태
    const [content, setContent] = useState('');  // 내용 상태

    // 뒤로 가기 버튼 클릭 시 모든 글 페이지로 리디렉션
    const backToArticle = () => {
        window.location.href = '/allarticle';
    };

    // 글 작성 완료 시 호출될 함수
    const handleWriteComplete = async () => {
        try {
            // 제목과 내용이 비어있지 않으면 API 호출
            if (title && content) {
                const response = await fetch('/post/create', {  // 실제 API 경로로 수정
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${localStorage.getItem('authToken')}`, // 로그인 상태 체크용 토큰
                    },
                    body: JSON.stringify({
                        title: title,        // 제목
                        content: content,    // 내용
                        likeCount: 0,        // 기본 likeCount 설정
                        publicStatus: true,  // 게시글 공개 여부
                        writerId: 1          // 작성자 ID (여기서는 예시로 1)
                    }),
                });

                if (response.ok) {
                    alert('글이 작성되었습니다.');
                    window.location.href = '/allarticle';  // 글 작성 후 모든 글 페이지로 리디렉션
                } else {
                    const data = await response.json();
                    alert(data.message || '글 작성에 실패했습니다.');
                }
            } else {
                alert('제목과 내용을 입력해주세요.');
            }
        } catch (error) {
            console.error('글 작성 중 오류 발생:', error);
            alert('글 작성 중 오류가 발생했습니다.');
        }
    };

    return (
        <div className={'root'}>
            <div className={'container'}>
                <img
                    className={'backArrow'}
                    src={'images/backarrow.svg'}
                    onClick={backToArticle}
                    alt="뒤로가기"
                />
                <div className={'pageTitle'}>글쓰기</div>
                <div className={'pageSemiTitle'}>공통</div>
                <button className={'writeComplete'} onClick={handleWriteComplete}>완료</button>

                <input
                    className={'titleInput'}
                    placeholder={'제목'}
                    value={title}  // title 상태 바인딩
                    onChange={(e) => setTitle(e.target.value)}  // 제목 상태 업데이트
                />
                <div className={'divideLine'}/>
                <textarea
                    className={'contentInput'}
                    placeholder={'내용을 입력하세요.'}
                    value={content}  // content 상태 바인딩
                    onChange={(e) => setContent(e.target.value)}  // 내용 상태 업데이트
                />
            </div>
        </div>
    );
};

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Write/>
);
