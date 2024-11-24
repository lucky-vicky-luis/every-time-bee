const {useState, useEffect} = React;


const Detail = () => {
    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'backArrow'} src={'images/backarrow.svg'}/>
                <div className={'pageTitle'}>전체게시판</div>
                <div className={'pageSemiTitle'}>공통</div>

                <div className={'articleContainer'}>
                    <img className={'authProfile'} src={'images/profile.svg'}/>
                    <div className={'title'}>그래서 님들 어케됨?</div>
                    <div className={'content'}>신설되는겨? 통합되는겨?<br/>나 궁금해 미쳐버러 ~~</div>

                    <img className={'unlike'} src={'images/unlike.svg'}/>
                    <div className={'likeAccount'}>5</div>

                    <div className={'divideLineOne'}/>
                    <div className={'postTime'}>16:48</div>

                    <div className={'divideLineTwo'}/>
                    <div className={'authNickname'}>익명</div>
                </div>
                <div className={'commentTitle'}>댓글</div>
                <div className={'commentCount'}>2</div>

                <div className={'commentBox'}>
                    <img className={'commentProfile'} src={'images/profile.svg'}/>
                    <div className={'commentNick'}>다람쥐</div>
                    <div className={'comment'}>오... 나도 몰라!ㅈㅅ ^^ .....</div>
                </div>
            </div>
        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Detail/>
);