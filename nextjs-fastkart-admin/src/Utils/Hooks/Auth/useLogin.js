import { useMutation } from "@tanstack/react-query";
import { useRouter } from "next/navigation";
import { useCookies } from "react-cookie";
import request from "../../AxiosUtils";
import { emailSchema, passwordSchema, YupObject, recaptchaSchema } from "../../Validation/ValidationSchemas";
import { login } from "../../AxiosUtils/API";

export const LogInSchema = YupObject({
  email: emailSchema,
  password: passwordSchema,
  recaptcha: recaptchaSchema
});

const LoginHandle = (responseData, router, setShowBoxMessage, setCookie) => {
  if (responseData.status === 200) {
    const token = responseData.data?.jwt || responseData.data?.token || responseData.data?.access_token;
    setCookie("uat", token, { path: "/", expires: new Date(Date.now() + 24 * 60 * 6000) });
    const account = responseData.data?.user || responseData.data;
    if (typeof window !== "undefined") {
      setCookie("account", JSON.stringify(account))
      localStorage.setItem("account", JSON.stringify(account));
    }
    router.push("/en/dashboard");
  } else {
    setShowBoxMessage(responseData.response.data.message);
  }
};

const useHandleLogin = (setShowBoxMessage) => {
  const [cookies, setCookie] = useCookies(["ue", "uat", "account"]);
  const router = useRouter();
  return useMutation(
    (data) =>
      request({
        url: login,
        method: "post",
        data,
      }),
    {
      onSuccess: (responseData) => LoginHandle(responseData, router, setShowBoxMessage, setCookie),
    },
  );
};

export default useHandleLogin;
