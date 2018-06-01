import React from 'react';
import {Button, Layout, Modal, Tabs} from 'antd';
import logo from './asset/logo.svg';
import './CoreLayout.css';
import {LoginComponent} from "../login/LoginComponent";
import {BookListComponent} from "../book/BookListComponent";
import {RegisterComponent} from "../login/RegisterComponent";
import {MenuComponent} from "../user/MenuComponent";
import {BookDetailComponent} from "../book/BookDetailComponent";
import {CartComponent} from "../user/CartComponent";
import {AddBookComponent} from "../book/AddBookComponent";
import {InfoComponent} from "../user/InfoComponent";
const { Header, Footer, Content } = Layout;
const TabPane = Tabs.TabPane;

export class CoreLayout extends React.Component {

    loginComponent = () => {
        return <Button onClick={() => {
            this.setState({modalVisible: true});
        }}
            style={{float: 'right', margin: '25px'}}
        >
            Login
        </Button>
    };

    userComponent = (userName) => {
        const onLogout = () => {
            this.setState({userZone: this.loginComponent()});
        };
        const onShowCart = () => {
            this.addTab('cart', '购物车', <CartComponent/>);
        };
        const onShowInfo = () => {
            this.addTab('info', '用户信息', <InfoComponent/>)
        };
        return <MenuComponent
            userName={userName}
            onLogout={onLogout}
            onShowCart={onShowCart}
            onShowInfo={onShowInfo}
        />
    };

    state = {
        modalVisible: false,
        TabObj: {
            activeKey: 'store',
            panes: [{
                key: 'store',
                title: '图书列表',
                content: <BookListComponent
                    onShowDetail={
                        (id, name) => {
                            this.addTab(id, name, <BookDetailComponent id={id}/>)
                        }
                    }
                    addBook={
                        () => {
                            this.addTab('addBook', '新增图书', <AddBookComponent/>)
                        }
                    }
                />,
                closable: false,
            }]
        },
        userZone: this.loginComponent(),
    };

    removeTab = (targetKey) => {
        const {TabObj} = this.state;
        if (targetKey === TabObj.activeKey) {
            TabObj.panes.some((value, index) => {
                if (value.key === targetKey) {
                    if (index > 0) {
                        TabObj.activeKey = TabObj.panes[index - 1].key;
                    }
                    else if (TabObj.panes.length > 1) {
                        TabObj.activeKey = TabObj.panes[1].key;
                    }
                    return true;
                }
                return false;
            });
        }
        TabObj.panes = TabObj.panes.filter(pane => pane.key !== targetKey);
        this.setState({TabObj});
    };

    addTab = (key, title, content) => {
        const {TabObj} = this.state;
        TabObj.activeKey = key;
        if (!TabObj.panes.some(pane => pane.key === key)) {
            TabObj.panes.push({key, title, content, closable: true});
        }
        this.setState({TabObj});
    };

    switchTab = (targetKey) => {
        const {TabObj} = this.state;
        TabObj.activeKey = targetKey;
        this.setState({TabObj});
    };

    render() {
        const {TabObj, modalVisible, userZone} = this.state;
        return (
            <div>
                <Modal
                    wrapClassName='login-modal'
                    width='400px'
                    style={{float: 'right'}}
                    footer={null}
                    mask={true}
                    visible={modalVisible}
                    maskClosable={true}
                    title="Login"
                    onCancel={() => this.setState({modalVisible: false})}
                >
                    <LoginComponent onLogin={() => {
                        this.setState({modalVisible: false});
                        this.setState({userZone: this.userComponent('userName')})
                    }}
                        onRegister={() => {
                            this.setState({modalVisible: false});
                            this.addTab('register', '注册账号', <RegisterComponent/>)
                        }}/>
                </Modal>
                <Layout>
                    <Header className="App-Header">
                        <img src={logo} className="App-logo" alt="logo" />
                        <div className="App-title">Welcome to NJU-BOOK-STORE</div>
                        {userZone}
                    </Header>
                    <Content className="App-Content">
                        <Tabs
                            activeKey={TabObj.activeKey}
                            animated
                            hideAdd
                            onEdit={this.removeTab}
                            onChange={this.switchTab}
                            type="editable-card"
                            >
                            {TabObj.panes.map(pane => <TabPane key={pane.key} tab={pane.title} closable={pane.closable}>
                                    {pane.content}
                                </TabPane>)}
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