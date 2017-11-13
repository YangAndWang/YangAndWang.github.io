import * as React from 'react'
import {Layout} from 'antd'
import './Content.less'

const AntdContent = Layout.Content

interface ContentProps {
    className: string
}

export class Content extends React.Component<ContentProps> {
    constructor(props: ContentProps) {
        super(props)
    }

    render() {
        return <AntdContent className={'learnwy-content'}/>
    }
}


