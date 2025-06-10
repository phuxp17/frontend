import { descriptionSchema, emailSchema, nameSchema, passwordConfirmationSchema, passwordSchema, phoneSchema } from "../../Utils/Validation/ValidationSchemas";

export const RegistrationValidationSchema = {
  name: nameSchema,
  email: emailSchema,
  password: passwordSchema,
  password_confirmation: passwordConfirmationSchema,
  store_name: nameSchema,
  description: descriptionSchema,
  address: descriptionSchema,
  phone: phoneSchema,
};

export const RegistrationInitialValues = {
  name: "",
  password: "",
  email: "",
  password_confirmation: "",
  store_name: "",
  description: "",
  address: "",
  phone: "",
  country_code: "91",
};
