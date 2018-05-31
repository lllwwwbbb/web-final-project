import React from 'react';
import './LoginComponent.css';
import {Button, Form, Icon, Input, Modal} from "antd";
const FormItem = Form.Item;

class _LoginComponent extends React.Component {

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                this.props.onLogin();
            }
        });
    };

    handleRegister = () => {
        console.log('Register!');
    };

    render() {
        const { getFieldDecorator } = this.props.form;
        return (
            <Form onSubmit={this.handleSubmit} className="login-form">
                <div>
                    <FormItem>
                        {getFieldDecorator('userName', {
                            rules: [{ required: true, message: 'Please input your username!' }],
                        })(
                            <Input prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)'}} />} placeholder="Username" />
                        )}
                    </FormItem>
                    <FormItem>
                        {getFieldDecorator('password', {
                            rules: [{ required: true, message: 'Please input your Password!' }],
                        })(
                            <Input prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)'}} />} type="password" placeholder="Password" />
                        )}
                    </FormItem>
                </div>
                <div>
                    <FormItem>
                        <Button type="primary" htmlType="submit" className="login-form-button">
                            Log in
                        </Button>
                        <a style={{float: 'right'}} onClick={this.handleRegister}>
                            register now!
                        </a>
                    </FormItem>
                </div>
            </Form>
        );
    }
}

export const LoginComponent = Form.create()(_LoginComponent);