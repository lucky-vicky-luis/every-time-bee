const {useState, useEffect} = React;


const Main = () => {
    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'logo'} src={'images/logo.png'}/>
                <button className={'logout'}>로그아웃</button>
                <img className={'profile'} src={'images/profile.svg'}/>
                <img className={'search'} src={'images/search.svg'}/>

                <div className={'school'}>대구소프트웨어마이스터고</div>
                <div className={'myArticle'}>
                    <div className={'myArticleTitle'}>내가 작성한 글</div>
                    <div className={'myArticleContent'}>본인이 작성한 글을 확인하고<br/>관리해요!</div>
                    <div className={'moreMyArticle'}>더보기</div>
                    <img className={'myArticleArrow'} src={'images/arrow.svg'}/>
                </div>

                <div className={'newArticle'}>방금 올라온 글</div>
                <div className={'moreNewArticle'}>더보기</div>
                <img className={'newArticleArrow'} src={'images/arrow.svg'}/>
                <div className={'newArticleContainer'}>
                    <div className={'newArticleBox'}>
                        <div className={'nickname'}>닉네임</div>
                        <div className={'title'}>그래서 님들 어케됨? 신설 되는거임?</div>
                        <img className={'new'} src={'images/new.svg'}/>
                    </div>
                </div>


            </div>
        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Main/>
);