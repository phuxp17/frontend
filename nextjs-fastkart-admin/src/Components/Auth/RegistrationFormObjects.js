import { emailSchema, nameSchema, passwordConfirmationSchema, passwordSchema } from "../../Utils/Validation/ValidationSchemas";

export const RegistrationValidationSchema = {
  firstName: nameSchema,
  lastName: nameSchema,
  email: emailSchema,
  password: passwordSchema,
  confirmPassword: passwordConfirmationSchema,
};

export const RegistrationInitialValues = {
  firstName: "",
  lastName: "",
  email: "",
  password: "",
  confirmPassword: "",
};
