using System;
using System.Collections.Generic;
using System.Linq;
using CodeFirstStuff.Models;
using Microsoft.AspNetCore.Builder;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace CodeFirstStuff.Data
{
    public class DummyData
    {
        public static void Initialize(IApplicationBuilder app)
        {
            using (var serviceScope = app.ApplicationServices.GetService<IServiceScopeFactory>().CreateScope())
            {
                var context = serviceScope.ServiceProvider.GetService<ApplicationDbContext>();
                context.Database.EnsureCreated();
                //context.Database.Migrate();

                // Look for any teams.
                if (context.Cities.Any())
                {
                    return;   // DB has already been seeded
                }

                var provinces = GetProvinces().ToArray();
                context.Provinces.AddRange(provinces);
                context.SaveChanges();

                var cities = DummyData.GetCities(context).ToArray();
                context.Cities.AddRange(cities);
                context.SaveChanges();

            }
        }

        public static List<Province> GetProvinces()
        {
            List<Province> provinces = new List<Province>() {
            new Province {
                ProvinceCode = "BC",
                ProvinceName = "British Columbia"
            },
            new Province {
                ProvinceCode = "AB",
                ProvinceName = "Alberta"
            },
            new Province {
                ProvinceCode = "ON",
                ProvinceName = "Ontario"
            }
        };

            return provinces;
        }

        public static List<City> GetCities(ApplicationDbContext context)
        {
            List<City> cities = new List<City>() {
            new City() {
                CityName="Vancouver",
                Population=1000000,
                ProvinceCode=context.Provinces.Find("BC").ProvinceCode
            },
            new City() {
                CityName="Burnaby",
                Population=800000,
                ProvinceCode=context.Provinces.Find("BC").ProvinceCode
            },
            new City() {
                CityName="Surrey",
                Population=700000,
                ProvinceCode=context.Provinces.Find("BC").ProvinceCode
            },
            new City() {
                CityName="Calgary",
                Population=900000,
                ProvinceCode=context.Provinces.Find("AB").ProvinceCode
            },
            new City() {
                CityName="Banff",
                Population=100000,
                ProvinceCode=context.Provinces.Find("AB").ProvinceCode
            },
            new City() {
                CityName="Edmonton",
                Population=1200000,
                ProvinceCode=context.Provinces.Find("AB").ProvinceCode
            },
            new City() {
                CityName="Toronto",
                Population=1300000,
                ProvinceCode=context.Provinces.Find("ON").ProvinceCode
            },
            new City() {
                CityName="Ottawa",
                Population=1100000,
                ProvinceCode=context.Provinces.Find("ON").ProvinceCode
            },
            new City() {
                CityName="Hamilton",
                Population=300000,
                ProvinceCode=context.Provinces.Find("ON").ProvinceCode
            },
        };

            return cities;
        }

    }

}