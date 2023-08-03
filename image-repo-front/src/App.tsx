import React from 'react';
import "./App.css";
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Header, Footer, LayoutComponent } from './components';
import { AboutPage, HomePage, TestPage, NotFoundPage, ImagesPage, ImagePage, ProfilePage, LoginPage, SignUpPage } from './pages'
import { ToastContainer } from 'react-toastify';

export interface IApplicationProps {}

const App: React.FunctionComponent<IApplicationProps> = (props) => {
    return (
        <>
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path='images'>
                        <Route index element={<ImagesPage />} />
                        <Route path=':number' element={<ImagePage />} />
                    </Route>
                    <Route path="about">
                        <Route index element={<AboutPage />} />
                        <Route path=":number" element={<AboutPage />} />
                    </Route>
                    <Route path="test" element={<TestPage />} />
                    <Route path="layout" element={<LayoutComponent />}>
                        <Route index element={<AboutPage />} />
                        <Route path=":number" element={<AboutPage />} />
                    </Route>
                    <Route path="profile" element={<ProfilePage />} />
                    <Route path="login" element={<LoginPage />} />
                    <Route path="signup" element={<SignUpPage />} />
                    <Route path="*" element={<NotFoundPage />} />
                </Routes>
                <Footer />
            </BrowserRouter>
            <ToastContainer/>
        </>
    );
};

export default App;