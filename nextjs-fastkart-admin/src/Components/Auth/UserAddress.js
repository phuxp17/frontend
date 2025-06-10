import { Field } from "formik";
import { Col } from "reactstrap";
import { ReactstrapInput } from "../ReactstrapFormik";

const UserAddress = () => {
  return (
    <>
      <Col xs="12">
        <Field
          name="address"
          component={ReactstrapInput}
          type="textarea"
          className="form-control"
          id="address"
          placeholder="Address"
          label="Address"
        />
      </Col>
    </>
  );
};

export default UserAddress;
