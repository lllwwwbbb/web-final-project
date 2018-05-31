import React from 'react';
import {Button, Layout, Modal, Tabs} from 'antd';
import logo from './asset/logo.svg';
import './CoreLayout.css';
import {LoginComponent} from "../login/LoginComponent";
import {BookListComponent} from "../book/BookListComponent";
import {removeTab, TabObj} from "./CoreLayoutStore";
const { Header, Footer, Content } = Layout;
const TabPane = Tabs.TabPane;

export class CoreLayout extends React.Component {
    state = {
        modalVisible: false,
    };

    render() {
        return (
            <div>
                <Modal
                    wrapClassName='login-modal'
                    width='400px'
                    style={{float: 'right'}}
                    footer={null}
                    mask={true}
                    visible={this.state.modalVisible}
                    maskClosable={true}
                    title="Login"
                    onCancel={() => this.setState({modalVisible: false})}
                >
                    <LoginComponent onLogin={() => this.setState({modalVisible: false})}/>
                </Modal>
                <Layout>
                    <Header className="App-Header">
                        <img src={logo} className="App-logo" alt="logo" />
                        <div className="App-title">Welcome to NJU-BOOK-STORE</div>
                        <Button onClick={() => this.setState({modalVisible: true})}
                                style={{float: 'right', margin: '25px'}}>
                            Login
                        </Button>
                    </Header>
                    <Content className="App-Content">
                        <Tabs
                            activeKey={TabObj.activeKey}
                            animated
                            hideAdd
                            onEdit={removeTab}
                            type="editable-card"
                            >
                            {TabObj.panes.map(pane => <TabPane key={pane.key} tab={pane.title}>{pane.content}</TabPane>)}
                        </Tabs>
                    </Content>
                    <Footer className="App-Footer">
                        NJU-BOOK-STORE @2018 Created By WEB final project group.
                    </Footer>
                </Layout>
            </div>
        )
    }
}