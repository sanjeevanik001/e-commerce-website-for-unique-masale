import { redirect } from "next/navigation"

// This project's deliverable is a Java Spring Boot + Thymeleaf app.
// Since this environment runs Next.js, we serve a static HTML preview
// (public/preview.html) so the site can be viewed in the browser here.
export default function Page() {
  redirect("/preview.html")
}
