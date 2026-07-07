/* =================================================================
   Unique Masale & Food Products - Frontend interactions
   Vanilla JS: theme toggle, sticky navbar, search, category filter,
   scroll-to-top, scroll reveal, active nav highlighting, loader.
   ================================================================= */
(function () {
    "use strict";

    /* ---------- Page loader ---------- */
    window.addEventListener("load", function () {
        var loader = document.getElementById("loader");
        if (loader) {
            setTimeout(function () { loader.classList.add("hidden"); }, 300);
        }
    });

    document.addEventListener("DOMContentLoaded", function () {

        /* ---------- Dark / Light mode ---------- */
        var root = document.documentElement;
        var toggle = document.getElementById("themeToggle");
        var stored = localStorage.getItem("um-theme");
        if (stored) {
            root.setAttribute("data-theme", stored);
        } else if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
            root.setAttribute("data-theme", "dark");
        }
        updateToggleIcon();

        if (toggle) {
            toggle.addEventListener("click", function () {
                var next = root.getAttribute("data-theme") === "dark" ? "light" : "dark";
                root.setAttribute("data-theme", next);
                localStorage.setItem("um-theme", next);
                updateToggleIcon();
            });
        }

        function updateToggleIcon() {
            if (!toggle) return;
            var isDark = root.getAttribute("data-theme") === "dark";
            toggle.innerHTML = isDark
                ? '<i class="bi bi-sun-fill"></i>'
                : '<i class="bi bi-moon-stars-fill"></i>';
            toggle.setAttribute("aria-label", isDark ? "Switch to light mode" : "Switch to dark mode");
        }

        /* ---------- Sticky navbar shadow ---------- */
        var navbar = document.getElementById("mainNav");
        var scrollTopBtn = document.getElementById("scrollTop");

        function onScroll() {
            var y = window.scrollY;
            if (navbar) navbar.classList.toggle("scrolled", y > 20);
            if (scrollTopBtn) scrollTopBtn.classList.toggle("show", y > 400);
            highlightNav();
        }
        window.addEventListener("scroll", onScroll, { passive: true });

        /* ---------- Scroll to top ---------- */
        if (scrollTopBtn) {
            scrollTopBtn.addEventListener("click", function () {
                window.scrollTo({ top: 0, behavior: "smooth" });
            });
        }

        /* ---------- Active nav link on scroll ---------- */
        var sections = Array.prototype.slice.call(document.querySelectorAll("section[id]"));
        var navLinks = Array.prototype.slice.call(document.querySelectorAll(".navbar .nav-link"));

        function highlightNav() {
            var pos = window.scrollY + 120;
            var currentId = "";
            sections.forEach(function (sec) {
                if (pos >= sec.offsetTop) currentId = sec.getAttribute("id");
            });
            navLinks.forEach(function (link) {
                link.classList.toggle("active", link.getAttribute("href") === "#" + currentId);
            });
        }

        /* Close mobile menu after clicking a link */
        var collapse = document.getElementById("navMenu");
        navLinks.forEach(function (link) {
            link.addEventListener("click", function () {
                if (collapse && collapse.classList.contains("show")) {
                    var bsCollapse = bootstrap.Collapse.getInstance(collapse)
                        || new bootstrap.Collapse(collapse, { toggle: false });
                    bsCollapse.hide();
                }
            });
        });

        /* ---------- Product search + category filter ---------- */
        var searchInput = document.getElementById("productSearch");
        var filterButtons = Array.prototype.slice.call(document.querySelectorAll(".filter-btn"));
        var productItems = Array.prototype.slice.call(document.querySelectorAll(".product-item"));
        var noResults = document.getElementById("noResults");
        var activeCategory = "all";

        function applyFilters() {
            var term = (searchInput ? searchInput.value : "").trim().toLowerCase();
            var visibleCount = 0;

            productItems.forEach(function (item) {
                var name = (item.getAttribute("data-name") || "").toLowerCase();
                var category = item.getAttribute("data-category") || "";
                var matchesCategory = activeCategory === "all" || category === activeCategory;
                var matchesTerm = term === "" || name.indexOf(term) !== -1;
                var show = matchesCategory && matchesTerm;
                item.style.display = show ? "" : "none";
                if (show) visibleCount++;
            });

            if (noResults) noResults.style.display = visibleCount === 0 ? "block" : "none";
        }

        if (searchInput) searchInput.addEventListener("input", applyFilters);

        filterButtons.forEach(function (btn) {
            btn.addEventListener("click", function () {
                filterButtons.forEach(function (b) { b.classList.remove("active"); });
                btn.classList.add("active");
                activeCategory = btn.getAttribute("data-filter");
                applyFilters();
            });
        });

        /* ---------- Scroll reveal animations ---------- */
        var revealEls = Array.prototype.slice.call(document.querySelectorAll(".reveal"));
        if ("IntersectionObserver" in window) {
            var observer = new IntersectionObserver(function (entries) {
                entries.forEach(function (entry) {
                    if (entry.isIntersecting) {
                        entry.target.classList.add("visible");
                        observer.unobserve(entry.target);
                    }
                });
            }, { threshold: 0.12 });
            revealEls.forEach(function (el) { observer.observe(el); });
        } else {
            revealEls.forEach(function (el) { el.classList.add("visible"); });
        }

        /* Initial state */
        onScroll();
    });
})();
