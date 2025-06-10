/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: false,
  swcMinify: true,
  env: {
    // For Local or deployment environments
    API_PROD_URL: process.env.API_PROD_URL || "http://localhost:8080/api/",
  },
  redirects: async () => {
    return [
      {
        source: "/",
        destination: "/en/dashboard",

        permanent: true,
      },
    ];
  },
  images: {
    remotePatterns: [
      {
        protocol: "http",
        hostname: "localhost:8000",
      },
      // {
      //   protocol: "http",
      //   hostname: "127.0.0.1:8000",
      // },
      // {
      //   protocol: "http",
      //   hostname: "localhost",
      // },
    ],
  },
  devIndicators: {
    buildActivity: false,
  },
};

module.exports = nextConfig;
