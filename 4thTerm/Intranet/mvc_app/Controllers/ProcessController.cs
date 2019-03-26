using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using mvc_app.Models;

namespace mvc_app.Controllers
{
    public class ProcessController : Controller
    {
        public IActionResult Index()
        {
            ViewData["message"] = "this is home page for processes";
            Process[] processes = Process.GetProcesses();
            ViewBag.Os = processes;
            return View();
        }

        public IActionResult Concrete()
        {

            ViewData["message"] = "this is home page for Concrete";
            Process[] processes = Process.GetProcesses();
            return View(processes);
        }

        public IActionResult Details(int id)
        {
            Process p = Process.GetProcessById(id);
            return View(p);
        }
    }
}