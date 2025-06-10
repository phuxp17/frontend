import { Field } from "formik";
import { Col } from "reactstrap";
import { ReactstrapInput } from "../ReactstrapFormik";

const UserPersonalInfo = () => {
  return (
    <>
      <Col sm="6">
        <Field name="firstName" type="text" component={ReactstrapInput} className="form-control" id="firstName" placeholder="First Name" label="FirstName" />
      </Col>
      <Col sm="6">
        <Field name="lastName" type="text" component={ReactstrapInput} className="form-control" id="lastName" placeholder="Last Name" label="LastName" />
      </Col>
      <Col sm="6">
        <Field name="email" type="email" component={ReactstrapInput} className="form-control" id="email" placeholder="Email" label="Email" />
      </Col>
      <Col sm="6">
        <Field name="password" type="password" component={ReactstrapInput} className="form-control" id="password" placeholder="Password" label="Password" />
      </Col>
      <Col sm="6">
        <Field name="confirmPassword" type="password" component={ReactstrapInput} className="form-control" id="confirmPassword" placeholder="Confirm Password" label="ConfirmPassword" />
      </Col>
    </>
  );
};

export default UserPersonalInfo;
