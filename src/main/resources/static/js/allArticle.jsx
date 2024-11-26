const {useState, useEffect} = React;


const Myarticle = () => {

    const backToMain = () => {
        window.location.href = '/main';
    }

    const goToWrite = () => {
        window.location.href = '/write';
    }
    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'backArrow'} onClick={backToMain} src={'images/backarrow.svg'}/>
                <div className={'pageTitle'}>전체게시판</div>
                <div className={'pageSemiTitle'}>공통</div>

                <button className={'writeButton'} onClick={goToWrite} >
                    <img className={'write'} src={'images/write.svg'}/>
                    글쓰기
                </button>

                <div className={'articleContainer'}>
                    <div className={'title'}>그래서 님들 어케됨?</div>
                    <div className={'articleContent'}>신설되는겨? 통합되는겨?<br/>나 궁금해 미쳐버러 ~~</div>

                    <img className={'unlike'} src={'images/unlike.svg'}/>
                    <div className={'likeAccount'}>5</div>

                    <div className={'divideLineOne'}/>
                    <div className={'postTime'}>16:48</div>

                    <div className={'divideLineTwo'}/>
                    <div className={'nickname'}>익명</div>

                    <button className={'delete'}>삭제하기</button>
                </div>

            </div>
        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Myarticle/>
);