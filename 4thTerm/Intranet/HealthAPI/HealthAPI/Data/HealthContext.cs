using HealthAPI.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HealthAPI.Data
{
    public class HealthContext : DbContext
    {
        public HealthContext(DbContextOptions options) : base(options) { }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            #region "Seed Data"

            //builder.Entity<Ailment>().HasData(
            //    DummyData.GetAilments()
            //);

            //builder.Entity<Ailment>().HasData(
            //    DummyData.GetMedications()
            //);

            //builder.Entity<Ailment>().HasData(
            //    DummyData.GetPatients(this)
            //);

            #endregion
        }

        public DbSet<Ailment> Ailments { get; set; }
        public DbSet<Medication> Medications { get; set; }
        public DbSet<Patient> Patients { get; set; }
    }

}
