const {useState, useEffect} = React;


const Admin = () => {
    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'logo'} src={'images/logo.png'}/>
                <button className={'logout'}>로그아웃</button>
                <img className={'profile'} src={'images/profile.svg'}/>
                <img className={'search'} src={'images/search.svg'}/>

                <div className={'articleManage'}>게시글 관리</div>
                <div className={'school'}>대구소프트웨어마이스터고</div>
                <img className={'downarrow'} src={'images/downarrow.svg'}/>

                <div className={'ArticleContainer'}>
                    <div className={'newArticleBox'}>
                        <div className={'nickname'}>닉네임</div>
                        <div className={'title'}>그래서 님들 어케됨? 신설 되는거임?</div>
                        <button className={'delete'}>삭제</button>
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
    <Admin/>
);