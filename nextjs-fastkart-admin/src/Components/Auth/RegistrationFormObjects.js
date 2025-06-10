import { emailSchema, nameSchema, passwordConfirmationSchema, passwordSchema, acceptSchema } from "../../Utils/Validation/ValidationSchemas";

export const RegistrationValidationSchema = {
  firstName: nameSchema,
  lastName: nameSchema,
  email: emailSchema,
  password: passwordSchema,
  confirmPassword: passwordConfirmationSchema,
  accept: acceptSchema,
};

export const RegistrationInitialValues = {
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  confirmPassword: "",
  accept: false,
};
