using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using lab1.Models;

namespace lab1.Controllers
{
    public class FileController : Controller
    {
        public IActionResult Index()
        {
            string[] files = Directory.EnumerateFiles(@"wwwroot/TextFiles", "*.txt")
                .Select(p => Path.GetFileNameWithoutExtension(p)).ToArray();
            Array.Sort(files);
            return View(files);
        }
        new public IActionResult Content(string id)
        {
            string fileContent = System.IO.File.ReadAllText(@"wwwroot/TextFiles/" + id + ".txt");
            ViewBag.FileContent = fileContent;
            return View();
        }

    }
}
