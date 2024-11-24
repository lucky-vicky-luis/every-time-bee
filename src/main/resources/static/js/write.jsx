const {useState, useEffect} = React;


const Write = () => {
    return (
        <div className={'root'}>
            <div className={'container'}>
                <img className={'backArrow'} src={'images/backarrow.svg'}/>
                <div className={'pageTitle'}>글쓰기</div>
                <div className={'pageSemiTitle'}>공통</div>
                <button className={'writeComplete'}>완료</button>

                <input className={'titleInput'} placeholder={'제목'}/>
                <div className={'divideLine'}/>
                <textarea className={'contentInput'} placeholder={'내용을 입력하세요.'}/>
            </div>
        </div>
    )
        ;
}

const root = ReactDOM.createRoot(
    document.getElementById('root')
);

root.render(
    <Write/>
);