import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function AdminProfile() {

    let [flag, setFlag] = useState(false);


    let navigate = useNavigate();

    // ------------------------------------------------------------- Session Management
    const logout = () => {

        window.sessionStorage.removeItem('username');
        window.sessionStorage.removeItem('role');
        // window.sessionStorage.clear();
        // window.location.reload(false);
        navigate("/");

    };

    useEffect(() => {

        const sessData = window.sessionStorage.getItem('username');
        const role = window.sessionStorage.getItem('role');
        console.log("Session console - ", sessData);
        console.log("Session Parsed - ", JSON.parse(sessData));

        if (sessData != '' && sessData != 'undefined' && sessData != null && role == 'ADMIN') {
            setFlag(true);
        }
        else {
            navigate('/adminlogin')
        }
    });

    // -------------------------------------------------------------------------

    return (
        <div>
            {flag &&
                <main id="main" className="main">

                    <div className="pagetitle">
                        <h1>Profile</h1>
                        <nav>
                            <ol className="breadcrumb">
                                <li className="breadcrumb-item"><a href="/">Home</a></li>
                                <li className="breadcrumb-item"><a href="/admindashboard ">Dashboard</a></li>
                                <li className="breadcrumb-item active">Profile</li>
                            </ol>
                        </nav>
                    </div>{/* End Page Title */}

                    <section className="section profile">
                        <div className="row">
                            <div className="col-xl-4">

                                <div className="card">
                                    <div className="card-body profile-card pt-4 d-flex flex-column align-items-center">

                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfJnD42Z587xFfkjk5zuq7QHXvFX6HBX4eEWJGcaL6vevYqvZBuGYTwBQTDuDKvBsjuRI&usqp=CAU" alt="Profile" className="rounded-circle" />
                                        <h2>Admin</h2>
                                        <h3></h3>
                                        <div className="social-links mt-2">
                                            <a href="#" className="twitter"><i className="bi bi-twitter"></i></a>
                                            <a href="#" className="facebook"><i className="bi bi-facebook"></i></a>
                                            <a href="#" className="instagram"><i className="bi bi-instagram"></i></a>
                                            <a href="#" className="linkedin"><i className="bi bi-linkedin"></i></a>
                                        </div>
                                    </div>
                                </div>

                            </div>

                            <div className="col-xl-8">

                                <div className="card">
                                    <div className="card-body pt-3">
                                        {/* Bordered Tabs */}
                                        <ul className="nav nav-tabs nav-tabs-bordered">

                                            <li className="nav-item">
                                                <button className="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                                            </li>

                                            {/* <li className="nav-item">
                                                <button className="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                                            </li> */}

                                           
                                            {/* <li className="nav-item">
                                                <button className="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
                                            </li> */}

                                        </ul>
                                        <div className="tab-content pt-2">

                                            <div className="tab-pane fade show active profile-overview" id="profile-overview">
                                               

                                                <h5 className="card-title">Profile Details</h5>

                                                <div className="row">
                                                    <div className="col-lg-3 col-md-4 label ">Full Name</div>
                                                    <div className="col-lg-9 col-md-8">Admin</div>
                                                </div>

                                                {/* <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Company</div>
                                                    <div className="col-lg-9 col-md-8">Lueilwitz, Wisoky and Leuschke</div>
                                                </div> */}

                                                {/* <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Job</div>
                                                    <div className="col-lg-9 col-md-8">Web Designer</div>
                                                </div> */}

                                                <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Country</div>
                                                    <div className="col-lg-9 col-md-8">India</div>
                                                </div>

                                                <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Address</div>
                                                    <div className="col-lg-9 col-md-8">Shivaji Nagar,pune.</div>
                                                </div>

                                                <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Phone</div>
                                                    <div className="col-lg-9 col-md-8">(436) 486-3538 x29071</div>
                                                </div>

                                                <div className="row">
                                                    <div className="col-lg-3 col-md-4 label">Email</div>
                                                    <div className="col-lg-9 col-md-8">admin@example.com</div>
                                                </div>

                                            </div>

                                           

                                        </div>{/* End Bordered Tabs */}

                                    </div>
                                </div>

                            </div>
                        </div>
                    </section>

                </main>
            }
        </div>
    )
}
