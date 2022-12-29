using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using PetClinicService.Models.Requests.ClientRequests;
using PetClinicService.Models;
using PetClinicService.Services;
using PetClinicService.Services.Impl;
using PetClinicService.Models.Requests.ConsultationRequests;


namespace PetClinicService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ConsultationController : ControllerBase
    {
        private IConsultationRepository _consultationRepository;

        public ConsultationController(IConsultationRepository consultationRepository)
        {
            _consultationRepository = consultationRepository;
        }

        [HttpPost("create")]
        public ActionResult<int> Create([FromBody] CreateConsultationRequest createRequest)
        {
            int res = _consultationRepository.Create(new Consultation
            {
                ClientId = createRequest.ClientId,
                PetId = createRequest.PetId,
                Description = createRequest.Description,
                ConsultationDate = createRequest.ConsultationDate,
            });
            return Ok(res);
        }

        [HttpPut("update")]
        public ActionResult<int> Update([FromBody] UpdateConsultationRequest updateRequest)
        {
            int res = _consultationRepository.Update(new Consultation
            {
                ConsultationId = updateRequest.ConsultationId,
                ClientId = updateRequest.ClientId,
                PetId = updateRequest.PetId,
                Description = updateRequest.Description,
                ConsultationDate = updateRequest.ConsultationDate,
            });
            return Ok(res);
        }

        [HttpDelete("delete")]
        public ActionResult<int> Delete(int consultationId)
        {
            int res = _consultationRepository.Delete(consultationId);
            return Ok(res);
        }

        [HttpGet("get-all")]
        public ActionResult<List<Consultation>> GetAll()
        {
            return Ok(_consultationRepository.GetAll());
        }

        [HttpGet("get-by-id")]
        public ActionResult<Consultation> GetById(int consultationId)
        {
            return Ok(_consultationRepository.GetById(consultationId));
        }
    }
}
