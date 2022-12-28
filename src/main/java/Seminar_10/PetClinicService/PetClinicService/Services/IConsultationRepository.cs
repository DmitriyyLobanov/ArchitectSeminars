using PetClinicService.Models;
using PetClinicService.Services;

namespace PetClinicService.Services
{
    public interface IConsultationRepository : IRepository<Consultation, int>
    {
    }
}
