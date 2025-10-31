// src/api/auth.js
import client from "./client";

export const login = async ({ email, password }) => {
  const { data } = await client.post("/auth/login", { email, password });
  return data; // shape depends on your backend (token, user, etc.)
};
